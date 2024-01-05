type instruction = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div

module StackMachine =
struct
  type t = {mutable l: float list}
  exception DivisionByZero of string
  exception TooFewArguments of string

  let init = function () -> {l = []}

  let reset stack = stack.l <- []

  let loadFloat stack number = stack.l <- number :: stack.l

  let loadInt stack number = loadFloat stack (float_of_int number)

  let copyTop stack =
    match stack.l with
    | h :: t -> stack.l <- h :: stack.l
    | [] -> raise (TooFewArguments "Stack is empty, no element can be copied")

  let binaryOperation stack operation =
    match stack.l with
    | el1 :: el2 :: t -> stack.l <- (operation el1 el2) :: t
    | _ :: [] -> raise (TooFewArguments "One argument missing")
    | [] -> raise (TooFewArguments "Stack is empty, operation cannot be performed")

  let result stack =
    match stack.l with
    | h :: _ -> h
    | [] -> raise (TooFewArguments "Stack is empty, no result can be obtained")

  let rec execute stack instructions =
    let executeInstruction instr =
      match instr with
      | Rst -> reset stack
      | LoadF number -> loadFloat stack number
      | LoadI number -> loadInt stack number
      | Cpy -> copyTop stack
      | Add -> binaryOperation stack ( +. )
      | Sub -> binaryOperation stack ( -. )
      | Mul -> binaryOperation stack ( *. )
      | Div -> if List.hd (List.tl stack.l) = 0. then raise (DivisionByZero "Cannot divide by 0") else binaryOperation stack ( /. )
    in
    match instructions with
    | currentInstruction :: restOfInstructions -> (
        executeInstruction currentInstruction;
        execute stack restOfInstructions
      )
    | [] -> ()
end

module type COPROCESSOR =
sig
  type t
  exception DivisionByZero of string
  exception TooFewArguments of string
  val init: unit -> t
  val result: t -> float
  val execute: t -> instruction list -> unit
end

module Coprocessor: COPROCESSOR = StackMachine

let testStack = Coprocessor.init ()
let _ = Coprocessor.execute testStack [LoadI 15; LoadF 20.; LoadI 10; Mul; Add;]
let testResult1 = Coprocessor.result testStack

let _ = Coprocessor.execute testStack [Rst; LoadF 100.5; LoadI 101; Sub; LoadF 2.5; Div; Cpy; Add]
let testResult2 = Coprocessor.result testStack

(* let _ = Coprocessor.execute testStack [Rst; Add] *)
(* let _ = Coprocessor.execute testStack [Rst; Cpy] *)
(* let _ = Coprocessor.execute testStack [Rst; LoadF 5.; Mul] *)
(* let _ = Coprocessor.execute testStack [Rst; LoadI 0; LoadI 1; Div] *)
let testResult3 = Coprocessor.result testStack

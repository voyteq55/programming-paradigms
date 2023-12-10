type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ltake = function
  (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, xs)) -> x :: ltake(n - 1, xs ())

let lrepeat repeatNumber lazyList =
  let rec innerRepeat currentRepetitionLeft lazyList =
    match lazyList with
    | LNil -> LNil
    | LCons(head, tail) ->
      if currentRepetitionLeft > 0
        then LCons(head, fun () -> innerRepeat (currentRepetitionLeft - 1) lazyList)
        else innerRepeat repeatNumber (tail ())
  in innerRepeat repeatNumber lazyList

let lfib =
  let rec helper a b =
    LCons(a, (fun () -> helper b (a + b)))
  in helper 0 1

let testLFib = ltake (15, lfib)
let tesLRepeat = ltake (30, lrepeat 3 lfib)

type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT)

let lBreadth lTree = 
  let rec lSearch queue =
    match queue with
    | [] -> LNil
    | LEmpty :: tail -> lSearch tail
    | LNode(element, leftLNode, rightLNode) :: tail -> LCons(element, fun () -> lSearch (tail @ [leftLNode (); rightLNode ()]))
  in lSearch [lTree]

let rec lTree n =
  LNode(n, (fun () -> lTree (2 * n)), (fun () -> lTree (2 * n + 1)))

let testBreadth = ltake (20, lBreadth (lTree 1))
let testBreadth = ltake (20, lBreadth LEmpty)

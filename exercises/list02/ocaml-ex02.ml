let rec fib n =
  if n <= 0 then 0 else
    match n with
      | 0 -> 0
      | 1 -> 1
      | _ -> fib (n - 1) + fib (n - 2)

let fibTail n =
  if n <= 0 then 0 else
    let rec fibTailRec (n, result, previous) =
      match n with
      | 1 -> result
      | _ -> fibTailRec (n - 1, result + previous, result)
    in fibTailRec (n, 1, 0)

let [_; _; x1; _; _] = [-2; -1; 0; 1; 2]
let [(_, _); (x2, _)] = [(1, 2); (0, 1)]

let test1_1 = fibTail 42
(* Takes forever: *)
(* let test1_2 = fib 42 *)

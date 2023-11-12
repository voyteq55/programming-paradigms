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

let accuracy = 10.0 ** -15.0
let root3 a =
  let rec root3Rec x_i =
    if abs_float (x_i ** 3.0 -. a) <= accuracy *. abs_float a then x_i else
      root3Rec (x_i +. (a /. x_i ** 2.0 -. x_i) /. 3.0)
  in root3Rec (if a > 1.0 then a /. 3.0 else a)

let rec initSegment (xs, ys) =
  match (xs, ys) with
  | ([], _) -> true
  | (hx :: tx, hy :: ty) -> hx = hy && initSegment (tx, ty)
  | (_, []) -> false

let rec replaceNth (xs, n, x) =
  match (xs, n) with
  | ([], _) -> []
  | (h :: t, 0) -> x :: t
  | (h :: t, _) -> h :: replaceNth (t, n - 1, x)

let test1_1 = fibTail 42
(* Takes forever: *)
(* let test1_2 = fib 42 *)

let root3of3 = root3 3.0
let root3of10 = root3 10.0
let root3of8 = root3 8.0
let root3ofNeg1 = root3 (-1.0)
let root3ofNeg20 = root3 (-20.0)
let root3of0p6 = root3 0.6

let test5_1 = initSegment ([1; 2; 3], [1; 2; 3; 4]) = true
let test5_2 = initSegment ([], [1; 2; 3; 4]) = true
let test5_3 = initSegment ([], []) = true
let test5_4 = initSegment ([1; 2; 3], []) = false
let test5_5 = initSegment ([1; 2; 3], [1; 2]) = false
let test5_6 = initSegment ([1; 2; 3], [3; 2; 1]) = false
let test5_7 = initSegment ([1; 1], [0; 1; 1]) = false
let test5_8 = initSegment ([1; 2], [1; 1; 2]) = false
let test5_9 = initSegment ([0; 1; 2], [0; 1; 2; 3; 4; 5; 6]) = true

let test6_1 = replaceNth ([0; 1; 2; 3; 4; 5], 0, 100) = [100; 1; 2; 3; 4; 5]
let test6_2 = replaceNth ([0; 1; 2; 3; 4; 5], 2, 100) = [0; 1; 100; 3; 4; 5]
let test6_3 = replaceNth ([0; 1; 2; 3; 4; 5], 4, 100) = [0; 1; 2; 3; 100; 5]
let test6_4 = replaceNth ([0; 1; 2; 3; 4; 5], 5, 100) = [0; 1; 2; 3; 4; 100]
let test6_5 = replaceNth ([0; 1; 2; 3; 4; 5], 6, 100) = [0; 1; 2; 3; 4; 5]
let test6_6 = replaceNth ([0; 1; 2; 3; 4; 5], -3, 100) = [0; 1; 2; 3; 4; 5]
let test6_7 = replaceNth ([0], 0, 100) = [100]

let ( >> ) f n = fun x ->
  let rec helper (index, acc) =
    if index <= 0 then acc else
      let element =
        match acc with
        | [] -> x
        | h :: _ -> f h
      in helper (index - 1, element :: acc)
  in helper (n, [])

let six_square_roots = sqrt >> 6
let six_square_roots_test1 = six_square_roots 6561.
let six_square_roots_test2 = six_square_roots 256.
let six_square_roots_test3 = six_square_roots 1.

let collatz x = if x mod 2 = 0 then x / 2 else 3 * x + 1
let collatz_numbers_from_1000 n = (collatz >> n) 1000
let collatz_test1 = collatz_numbers_from_1000 10
let collatz_test2 = collatz_numbers_from_1000 5
let collatz_test3 = collatz_numbers_from_1000 1
let collatz_test4 = collatz_numbers_from_1000 0
let collatz_test5 = collatz_numbers_from_1000 (-5)

let double_list_test1 = ((fun xs -> xs @ xs) >> 4) ["a"; "b"]
let double_list_test2 = ((fun xs -> xs @ xs) >> 0) [1; 2; 3]

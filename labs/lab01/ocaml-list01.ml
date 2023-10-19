let reverse4 (e1, e2, e3, e4) = (e4, e3, e2, e1)

let rec sumProd = function (s, e) -> 
  if s >= e then (0, 1) else
    let sumProdResult = sumProd (s + 1, e)
    in (s + fst sumProdResult, s * snd sumProdResult)

let rec sumOfDivisors = function (n, currentDivisor) ->
  if n <= 1 then 0 else
    if currentDivisor * currentDivisor > n then 1 else (* adding 1 because dividing starts from 2, every number is divisible by 1*)
      sumOfDivisors (n, currentDivisor + 1) +
      (if n mod currentDivisor <> 0 then 0 else 
        currentDivisor + (if currentDivisor * currentDivisor < n then n / currentDivisor else 0))

let isPerfect = function n -> if n = 0 then false else n = sumOfDivisors (n, 2)

let rec insert = function (list, element, index) ->
  if list = [] then [element] else
    if index <= 0 then element :: list else
      List.hd list :: insert (List.tl list, element, index - 1)

(* TESTS *)

let test1_1 = reverse4 (1, 2, 3, 4) = (4, 3, 2, 1)
let test1_2 = reverse4 ("a", (), 5, [0]) = ([0], 5, (), "a")

let test2_1 = sumProd (1, 7) = (21, 720)
let test2_2 = sumProd (-5, -1) = (-14, 120)
let test2_3 = sumProd (5, 2) = (0, 1)
let test2_4 = sumProd (-5, 6) = (0, 0)

let test3_1 = isPerfect 1 = false
let test3_2 = isPerfect 2 = false
let test3_3 = isPerfect 4 = false
let test3_4 = isPerfect 6 = true
let test3_5 = isPerfect 12 = false
let test3_6 = isPerfect 28 = true
let test3_7 = isPerfect 64 = false
let test3_8 = isPerfect 496 = true
let test3_9 = isPerfect 4064 = false
let test3_10 = isPerfect 8128 = true
let test3_11 = isPerfect (-1) = false
let test3_12 = isPerfect (-6) = false
let test3_13 = isPerfect 0 = false

let test4_1 = insert ([1; 2; 3; 4], 100, -4) = [100; 1; 2; 3; 4]
let test4_2 = insert ([1; 2; 3; 4], 100, 0) = [100; 1; 2; 3; 4]
let test4_3 = insert ([1; 2; 3; 4], 100, 1) = [1; 100; 2; 3; 4]
let test4_4 = insert ([1; 2; 3; 4], 100, 3) = [1; 2; 3; 100; 4]
let test4_5 = insert ([1; 2; 3; 4], 100, 4) = [1; 2; 3; 4; 100]
let test4_6 = insert ([1; 2; 3; 4], 100, 10) = [1; 2; 3; 4; 100]
let test4_7 = insert ([], 100, 0) = [100]
let test4_8 = insert ([], 100, 15) = [100]
let test4_9 = insert ([], 100, -15) = [100]

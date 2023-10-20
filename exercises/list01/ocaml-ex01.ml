let rec flatten xss =
  if xss = [] then [] else
    List.hd xss @ flatten (List.tl xss)

let rec count (element, my_list) =
  if my_list = [] then 0 else
    (if element = List.hd my_list then 1 else 0) + count (element, List.tl my_list)

let rec replicate (x, n) =
  if n <= 0 then [] else
    x :: replicate (x, n - 1)

let test1_1 = flatten [] = []
let test1_2 = flatten [[]; []] = []
let test1_3 = flatten [[1; 2]; [3; 4]] = [1; 2; 3; 4]
let test1_4 = flatten [[];[];[1];[2; 3; 5]] = [1; 2; 3; 5]

let test2_1 = count (3, [1; 2; 3; 4]) = 1
let test2_2 = count ([[]], [[]; []; [[[]]]; [[]]; [[]]]) = 2
let test2_3 = count ("a", ["a"; "A"; "a"; "aaaaaaa"; "b"; "a"]) = 3

let test3_1 = replicate ("aa", 5) = ["aa"; "aa"; "aa"; "aa"; "aa"]
let test3_2 = replicate ([], 2) = [[]; []]
let test3_3 = replicate ("aaaaa", 0) = []
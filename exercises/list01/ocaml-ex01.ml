let rec flatten xss =
  if xss = [] then [] else
    List.hd xss @ flatten (List.tl xss)

let rec count (element, my_list) =
  if my_list = [] then 0 else
    (if element = List.hd my_list then 1 else 0) + count (element, List.tl my_list)

let rec replicate (x, n) =
  if n <= 0 then [] else
    x :: replicate (x, n - 1)

let rec sqrList list =
  if list = [] then [] else
    let x = List.hd list in x * x :: sqrList (List.tl list)

let rec listLength list =
  if list = [] then 0 else
    1 + listLength (List.tl list)

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

let test4_1 = sqrList [] = []
let test4_2 = sqrList [1; 2; 3; -4] = [1; 4; 9; 16]
let test4_3 = sqrList [0; -1; -2; -3] = [0; 1; 4; 9]
let test4_4 = sqrList [5; 0; 0; 7; 7] = [25; 0; 0; 49; 49]

let test6_1 = listLength [] = 0
let test6_2 = listLength [[[]]; []; []; []] = 4
let test6_3 = listLength [100; 200; 300; 400; 500] = 5
let test6_4 = listLength ["a"; "b"; "c"] = 3

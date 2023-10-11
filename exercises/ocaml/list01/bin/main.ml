open Printf

let rec flatten l =
  match l with
  | [] -> []
  | h :: t -> h @ flatten t;;

let rec count element my_list =
  match my_list with
  | [] -> 0
  | x :: tail -> (if x = element then 1 else 0) + count element tail;;

let () = List.iter (printf "%d ") (flatten [[1; 2]; [3; 4]])
let () = List.iter (printf "%d ") (flatten [[];[];[1];[2; 3; 5]])
let () = print_int (count "a" ["1"; "a"; "234"; "aaa"; "a"])
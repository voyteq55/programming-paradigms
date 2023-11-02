let cutAndMend a b listToCut =
  match a <= b with
  | true -> let rec cutAndMendRec (listFragment, index) =
      match (listFragment, index < a, index <= b) with
      | ([], _, _) -> []
      | (h :: t, true, _) -> h :: cutAndMendRec (t, index + 1)
      | (_ :: t, _, true) -> cutAndMendRec (t, index + 1)
      | _ -> listFragment
    in cutAndMendRec (listToCut, 0)
  | false -> []

let cutAndMend15 = cutAndMend 1 5
let test1_1 = cutAndMend15 [0; 1; 2; 3; 4; 5; 6; 7]
let test1_2 = cutAndMend15 [0; 1; 2; 3; 4]
let test1_3 = cutAndMend15 [0]
let test1_4 = cutAndMend15 []

let cutAndMend03 = cutAndMend 0 3
let test1_5 = cutAndMend03 [0; 1; 2; 3; 4; 5; 6; 7]
let test1_6 = cutAndMend03 [0; 1; 2; 3; 4]
let test1_7 = cutAndMend03 [0]
let test1_8 = cutAndMend03 []

let cutAndMend00 = cutAndMend 0 0
let test1_9 = cutAndMend00 [0; 1; 2; 3; 4; 5; 6; 7]
let test1_10 = cutAndMend00 [0; 1; 2; 3; 4]
let test1_11 = cutAndMend00 [0]
let test1_12 = cutAndMend00 []

let cutAndMend44 = cutAndMend 4 4
let test1_13 = cutAndMend44 [0; 1; 2; 3; 4; 5; 6; 7]
let test1_14 = cutAndMend44 [0; 1; 2; 3; 4]
let test1_15 = cutAndMend44 [0]
let test1_16 = cutAndMend44 []

let cutAndMend21 = cutAndMend 2 1
let test1_13 = cutAndMend21 [0; 1; 2; 3; 4; 5; 6; 7]
let test1_14 = cutAndMend21 [0; 1; 2; 3; 4]
let test1_15 = cutAndMend21 [0]
let test1_16 = cutAndMend21 []

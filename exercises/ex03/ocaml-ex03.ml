let f1 x = x 2 2
let f2 x y z = x (y ^ z)

let curry3 f x y z = f (x, y, z)
let fullCurry3 = fun f -> fun x -> fun y -> fun z -> f (x, y, z)

let uncurry3 f (x, y, z) = f x y z
let fullUncurry3 = fun f -> fun (x, y, z) -> f x y z

let rec sumProd xs =
  match xs with
  | h::t -> let (s, p) = sumProd t in (h + s, h * p)
  | [] -> (0, 1)

let sumProdFoldLeft xs = List.fold_left (fun (s1, p1) x -> (s1 + x, p1 * x)) (0, 1) xs

let testList = [1; 2; 3; 4; 5; 6; 7]
let testResult1 = sumProd testList
let testResult2 = sumProdFoldLeft testList

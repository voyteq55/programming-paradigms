let f1 x = x 2 2
let f2 x y z = x (y ^ z)

let curry3 f x y z = f (x, y, z)
let fullCurry3 = fun f -> fun x -> fun y -> fun z -> f (x, y, z)

let uncurry3 f (x, y, z) = f x y z
let fullUncurry3 = fun f -> fun (x, y, z) -> f x y z

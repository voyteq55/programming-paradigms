def curry3[A, B, C, D](f: (A, B, C) => D)(a: A)(b: B)(c: C): D = f(a, b, c)

def uncurry3[A, B, C, D](f: A => B => C => D, a: A, b: B, c: C): D = f(a)(b)(c)

def sumProd(xs: List[Int]): (Int, Int) =
    xs match
        case h::t =>
            val (s, p) = sumProd(t)
            (h + s, h * p)
        case Nil => (0, 1)

def sumProdFoldLeft(xs: List[Int]): (Int, Int) =
    xs.foldLeft((0, 1)) {
        case ((s, p), x) => (s + x, p * x)
    }

sumProd(List(1, 2, 3, 4, 5, 6, 7))
sumProdFoldLeft(List(1, 2, 3, 4, 5, 6, 7))
sumProd(List())
sumProdFoldLeft(List())

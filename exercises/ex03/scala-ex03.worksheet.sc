def curry3[A, B, C, D](f: (A, B, C) => D)(a: A)(b: B)(c: C): D = f(a, b, c)

def uncurry3[A, B, C, D](f: A => B => C => D, a: A, b: B, c: C): D = f(a)(b)(c)

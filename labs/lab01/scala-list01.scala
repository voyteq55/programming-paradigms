def reverse4[T](e1: T, e2: T, e3: T, e4: T) = (e4, e3, e2, e1);

@main def main = {
    println(reverse4 (1, 2, 3, 4))
    println(reverse4 ("s", 4, List("a, b"), ()))
}
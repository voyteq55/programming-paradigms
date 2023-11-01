def fib(n: Int): Int =
    n match
        case 0 => 0
        case 1 => 1
        case _ => fib(n - 1) + fib(n - 2)

def fibTail(n: Int) = {
    def fibTailRec(n: Int, result: Int, previous: Int): Int =
        n match
            case n if n <= 0 => 0
            case 1 => result
            case _ => fibTailRec(n - 1, result + previous, result)
    fibTailRec(n, 1, 0)
}

val List[Int](_, _, x1, _, _) = List[Int](-2, -1, 0, 1, 2)
val List[Tuple2[Int, Int]]((_, _), (x2, _)) = List[Tuple2[Int, Int]]((1, 2), (0, 1))

fib(42)
fibTail(42)

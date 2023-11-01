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

fib(42)
fibTail(42)

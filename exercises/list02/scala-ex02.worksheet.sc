import scala.math.pow
import scala.math.abs

def fib(n: Int): Int =
    if n <= 0 then 0 else
        n match
            case 0 => 0
            case 1 => 1
            case _ => fib(n - 1) + fib(n - 2)

def fibTail(n: Int) = {
    if n <= 0 then 0 else
        def fibTailRec(n: Int, result: Int, previous: Int): Int =
            n match
                case 1 => result
                case _ => fibTailRec(n - 1, result + previous, result)
        fibTailRec(n, 1, 0)
}

val accuracy = pow(10.0, -15.0)
def root3(a: Double) =
    def root3Rec(x_i: Double): Double =
        if abs(pow(x_i, 3) - a) <= accuracy * abs(a) then x_i else
            root3Rec(x_i + (a / pow(x_i, 2) - x_i) / 3)
    root3Rec(if a > 0 then a / 3 else a)

val List[Int](_, _, x1, _, _) = List[Int](-2, -1, 0, 1, 2)
val List[Tuple2[Int, Int]]((_, _), (x2, _)) = List[Tuple2[Int, Int]]((1, 2), (0, 1))

fib(42)
fibTail(42)

root3(3)
root3(10)
root3(8)
root3(-1)
root3(-20)
root3(0.6)
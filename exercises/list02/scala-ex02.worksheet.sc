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
    root3Rec(if a > 1 then a / 3 else a)

val root3Function: Double => Double = (a: Double) => {
    def root3Rec(x_i: Double): Double =
        if abs(pow(x_i, 3) - a) <= accuracy * abs(a) then x_i else
            root3Rec(x_i + (a / pow(x_i, 2) - x_i) / 3)
    root3Rec(if a > 1 then a / 3 else a)
}

val List[Int](_, _, x1, _, _) = List[Int](-2, -1, 0, 1, 2)
val List[Tuple2[Int, Int]]((_, _), (x2, _)) = List[Tuple2[Int, Int]]((1, 2), (0, 1))

def initSegment[A](xs: List[A], ys: List[A]): Boolean =
    (xs, ys) match
        case (List[A](), _) => true
        case (xh :: xt, yh :: yt) => xh == yh && initSegment(xt, yt)
        case (_, List[A]()) => false

def replaceNth[A](xs: List[A], n: Int, x: A): List[A] =
    (xs, n) match
        case (List[A](), _) => List[A]()
        case (h :: t, 0) => x :: t
        case (h :: t, _) => h :: replaceNth(t, n - 1, x)

fib(42)
fibTail(42)

root3(3)
root3(10)
root3(8)
root3(-1)
root3(-20)
root3(0.6)

root3Function(3)
root3Function(10)
root3Function(8)
root3Function(-1)
root3Function(-20)
root3Function(0.6)

initSegment(List(1, 2, 3), List(1, 2, 3, 4))
initSegment(List(), List(1, 2, 3, 4))
initSegment(List(), List())
initSegment(List(1, 2, 3), List())
initSegment(List(1, 2, 3), List(1, 2))
initSegment(List(1, 2, 3), List(3, 2, 1))
initSegment(List(1, 1), List(0, 1, 1))
initSegment(List(1, 2), List(1, 1, 2))
initSegment(List(0, 1, 2), List(0, 1, 2, 3, 4, 5, 6))

replaceNth(List(0, 1, 2, 3, 4, 5), 0, 100)
replaceNth(List(0, 1, 2, 3, 4, 5), 2, 100)
replaceNth(List(0, 1, 2, 3, 4, 5), 4, 100)
replaceNth(List(0, 1, 2, 3, 4, 5), 5, 100)
replaceNth(List(0, 1, 2, 3, 4, 5), 6, 100)
replaceNth(List(0, 1, 2, 3, 4, 5), -3, 100)
replaceNth(List(0), 0, 100)

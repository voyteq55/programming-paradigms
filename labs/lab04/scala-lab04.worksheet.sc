sealed trait tree3[+A]
    case object Empty extends tree3[Nothing]
    case class Node[+A](element: A, t1: tree3[A], t2: tree3[A], t3: tree3[A]) extends tree3[A]

val testTree1 = Empty
val testTree2 = Node("abcd", Empty, Node("aaa", Empty, Empty, Empty), Empty)
val testTree3 = Node(1, Node(2, Empty, Empty, Empty), Node(3, Node(5, Empty, Empty, Empty), Empty, Node(6, Empty, Empty, Empty)), Node(4, Empty, Empty, Empty))

def mapTree3[A,B](mapFunction: A => B)(tree: tree3[A]): tree3[B] =
    tree match
        case Empty => Empty
        case Node(element, t1, t2, t3) => Node(mapFunction(element), mapTree3(mapFunction)(t1), mapTree3(mapFunction)(t2), mapTree3(mapFunction)(t3))

val cube: (Int => Int) = x => x * x * x
val repeatString: (String => String) = s => s + s

mapTree3(cube)(testTree1)
mapTree3(repeatString)(testTree2)
mapTree3(cube)(testTree3)
mapTree3(x => x.toString())(testTree3)

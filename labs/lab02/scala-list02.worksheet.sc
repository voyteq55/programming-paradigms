def cutAndMend[T](a: Int)(b: Int)(listToCut: List[T]) =
    (a <= b) match
        case true =>
            def cutAndMendRec(listFragment: List[T], index: Int): List[T] =
                (listFragment, index < a, index <= b) match
                    case (List(), _, _) => List()
                    case (h :: t, true, _) => h :: cutAndMendRec(t, index + 1)
                    case (_ :: t, _, true) => cutAndMendRec(t, index + 1)
                    case _ => listFragment
            cutAndMendRec(listToCut, 0)
        case false => List()

def split2Rec[T](listToSplit: List[T]): (List[T], List[T]) =
    listToSplit match
        case h1 :: h2 :: t =>
            val (t1, t2) = split2Rec(t)
            (h1 :: t1, h2 :: t2)
        case h :: Nil => (List(h), Nil)
        case Nil => (Nil, Nil)

def split2Tail[T](listToSplit: List[T]): (List[T], List[T]) =
    def reverse(listToReverse: List[T]): List[T] =
        def reverseInner(l: List[T], acc: List[T]): List[T] =
            l match
                case Nil => acc
                case h :: t => reverseInner(t, h :: acc)
        reverseInner(listToReverse, Nil)
    def split2TailRecursive(originalList: List[T], acc1: List[T], acc2: List[T]): (List[T], List[T]) =
        originalList match
            case Nil => (reverse(acc1), reverse(acc2))
            case h :: t => split2TailRecursive(t, h :: acc2, acc1)
    split2TailRecursive(listToSplit, Nil, Nil)

def substituteIfIn[T](inputList: List[T])(substituteList: List[T])(substituteElement: T): List[T] =
    def isContainedIn(element: T, lst: List[T]): Boolean =
        lst match
            case Nil => false
            case h :: t => (h == element) || isContainedIn(element, t)
    inputList match
        case Nil => Nil
        case h :: t => (if isContainedIn(h, substituteList) then substituteElement else h) :: 
            substituteIfIn(t)(substituteList)(substituteElement)

def cutAndMend15 = cutAndMend(1)(5)
cutAndMend15(List(0, 1, 2, 3, 4, 5, 6, 7))
cutAndMend15(List(0, 1, 2, 3, 4))
cutAndMend15(List(0))
cutAndMend15(List())

def cutAndMend03 = cutAndMend(0)(3)
cutAndMend03(List(0, 1, 2, 3, 4, 5, 6, 7))
cutAndMend03(List(0, 1, 2, 3, 4))
cutAndMend03(List(0))
cutAndMend03(List())

def cutAndMend00 = cutAndMend(0)(0)
cutAndMend00(List(0, 1, 2, 3, 4, 5, 6, 7))
cutAndMend00(List(0, 1, 2, 3, 4))
cutAndMend00(List(0))
cutAndMend00(List())

def cutAndMend44 = cutAndMend(4)(4)
cutAndMend44(List(0, 1, 2, 3, 4, 5, 6, 7))
cutAndMend44(List(0, 1, 2, 3, 4))
cutAndMend44(List(0))
cutAndMend44(List())

def cutAndMend21 = cutAndMend(2)(1)
cutAndMend21(List(0, 1, 2, 3, 4, 5, 6, 7))
cutAndMend21(List(0, 1, 2, 3, 4))
cutAndMend21(List(0))
cutAndMend21(List())

split2Rec(List(0, 1, 2, 3, 4, 5, 6, 7, 8))
split2Tail(List(0, 1, 2, 3, 4, 5, 6, 7, 8))
split2Rec(List(0, 1, 2, 3, 4, 5, 6, 7))
split2Tail(List(0, 1, 2, 3, 4, 5, 6, 7))
split2Rec(List(0, 1))
split2Tail(List(0, 1))
split2Rec(List(0))
split2Tail(List(0))
split2Rec(List())
split2Tail(List())

substituteIfIn(List(1, 2, 3, 4, 5))(List(2, 4))(0)
substituteIfIn(Nil)(List(1, 2, 3))(100)
substituteIfIn(List(1, 2, 3, 4, 5))(List(6, 7, 8))(100)
substituteIfIn(List(1, 2, 1, 3, 1, 4, 1))(List(1))(100)
substituteIfIn(List(1, 2, 3, 4, 5))(Nil)(100)
substituteIfIn(List(1, 2, 3, 2, 4, 2, 3, 4, 5, 2, 3))(List(2, 4, 5))(100)
substituteIfIn(Nil)(Nil)(100)

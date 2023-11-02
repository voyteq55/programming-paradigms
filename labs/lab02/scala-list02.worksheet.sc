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

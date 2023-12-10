def lrepeat[A](repeatNumber: Int, lazyList: LazyList[A]) =
    def innerRepeat(currentRepetitionsLeft: Int, lazyList: LazyList[A]): LazyList[A] =
        lazyList match
            case LazyList() => LazyList()
            case lazyListHead #:: lazyListTail =>
                if currentRepetitionsLeft > 0 then lazyListHead #:: innerRepeat(currentRepetitionsLeft - 1, lazyList) else
                    innerRepeat(repeatNumber, lazyList = lazyListTail)
    innerRepeat(repeatNumber, lazyList)

def lfib(): LazyList[Int] =
    def helperFib(firstValue: Int, secondValue: Int): LazyList[Int] =
        firstValue #:: helperFib(secondValue, (firstValue + secondValue))
    helperFib(0, 1)

lfib().take(15).toList
lrepeat(3, lfib().take(20)).toList

sealed trait lBT[+A]
    case object LEmpty extends lBT[Nothing]
    case class LNode[+A](element: A, leftLNode: () => lBT[A], rightLNode: () => lBT[A]) extends lBT[A]

def lBreadth[A](ltree: lBT[A]): LazyList[A] =
    def lSearch(queue: List[lBT[A]]): LazyList[A] =
        queue match
            case Nil => LazyList()
            case LEmpty :: tail => lSearch(tail)
            case LNode(element, leftLNode, rightLNode) :: tail => element #:: lSearch(tail ++ List(leftLNode(), rightLNode()))
    lSearch(List(ltree))

def lTree(n: Int): lBT[Int] =
    LNode(n, () => lTree(2 * n), () => lTree(2 * n + 1))

lBreadth(lTree(1)).take(20).toList
lBreadth(LEmpty).take(20).toList


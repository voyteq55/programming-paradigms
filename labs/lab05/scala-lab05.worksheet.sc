val finiteNumbers = LazyList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
val infiniteNumbers = LazyList.from(1)

def skipTakeL[A](lazyList: LazyList[A]): LazyList[A] =
    def innerSkipTakeL(lazyList: LazyList[A], initialToSkip: Int, leftToSkip: Int): LazyList[A] =
        lazyList match
            case LazyList() => LazyList()
            case lazyListHead #:: lazyListTail =>
                if (leftToSkip == 0) then 
                    lazyListHead #:: innerSkipTakeL(lazyListTail, initialToSkip + 1, initialToSkip + 1)
                    else
                        innerSkipTakeL(lazyListTail, initialToSkip, leftToSkip - 1)
    innerSkipTakeL(lazyList, 0, 0)
    
skipTakeL(finiteNumbers).toList
skipTakeL(infiniteNumbers).take(15).toList

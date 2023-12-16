def declaracci(m: Int, n: Int): List[Int] =
    def declaracciLazy(m: Int): LazyList[Int] =
        def fibonacciLazy(): LazyList[Int] =
            def innerFibLazy(firstValue: Int, secondValue: Int): LazyList[Int] =
                firstValue #:: innerFibLazy(secondValue, firstValue + secondValue)
            innerFibLazy(1, 1)
        if m == 1 then fibonacciLazy() else
            val lowerSkiponacci = declaracciLazy(m - 1)
            def innerDeclaracciLazy(skiponacci: LazyList[Int]): LazyList[Int] =
                skiponacci match
                    case firstOfLower #:: lowerTail => (firstOfLower + lowerTail.head) #:: innerDeclaracciLazy(lowerTail)
            innerDeclaracciLazy(lowerSkiponacci)
    if m >= 1 then declaracciLazy(m).take(n).toList else Nil

declaracci(1, 10)
declaracci(2, 6)
declaracci(4, 10)
declaracci(2, 0)
declaracci(0, 10)

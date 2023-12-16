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

def declaracci2(m: Int, n: Int): List[Int] =
    def declaracciLazy(m: Int): LazyList[Int] =
        def fibonacciLazy(): LazyList[Int] =
            def innerFibLazy(firstValue: Int, secondValue: Int): LazyList[Int] =
                firstValue #:: innerFibLazy(secondValue, firstValue + secondValue)
            innerFibLazy(1, 1)
        def innerDeclaracciLazy(degree: Int, skiponacci: LazyList[Int]): LazyList[Int] = 
            if degree == 1 then skiponacci else
                skiponacci match
                    case _ #:: _ #:: tail => innerDeclaracciLazy(degree - 1, tail)
        innerDeclaracciLazy(m, fibonacciLazy())
    if m >= 1 then declaracciLazy(m).take(n).toList else Nil

declaracci(1, 10)
declaracci(2, 6)
declaracci(4, 10)
declaracci(2, 0)
declaracci(0, 10)

declaracci2(1, 10)
declaracci2(2, 6)
declaracci2(4, 10)
declaracci2(2, 0)
declaracci2(0, 10)

def imperacci(m: Int, n: Int): Array[Int] =
    if m >= 1 then  
        val skiponacciSequence = new Array[Int](n)
        var previousValue = 0
        var currentValue = 1
        var index = 0
        var skiponacciDegree = 2 * (m - 1)
        while index < n do
            if skiponacciDegree == 0 then
                skiponacciSequence(index) = currentValue
                index = index + 1
            else
                skiponacciDegree = skiponacciDegree - 1
            currentValue = previousValue + currentValue
            previousValue = currentValue - previousValue
        skiponacciSequence
    else
        new Array[Int](0)

imperacci(1, 10).toList
imperacci(2, 6).toList
imperacci(4, 10).toList
imperacci(2, 0).toList
imperacci(0, 6).toList

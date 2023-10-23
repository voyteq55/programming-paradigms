def reverse4[T](e1: T, e2: T, e3: T, e4: T) = (e4, e3, e2, e1);

def sumProd(s: Int, e: Int): (Int, Int) =
    if s >= e then (0, 1) else {
        val sumProdResult = sumProd(s + 1, e)
        (s + sumProdResult._1, s * sumProdResult._2)
    }

def isPerfect(n: Int) = if n == 0 then false else {
    def sumOfDivisors(n: Int, currentDivisor: Int): Int =
        if n <= 1 then 0 else
        if currentDivisor * currentDivisor > n then 1 else // adding 1 because dividing starts from 2, every number is divisible by 1
            sumOfDivisors(n, currentDivisor + 1) +
            (if n % currentDivisor != 0 then 0 else 
                currentDivisor + (if currentDivisor * currentDivisor < n then n / currentDivisor else 0))
    n == sumOfDivisors(n, 2)
}

def insert[T](list: List[T], element: T, index: Int): List[T] =
    if list == List() then List(element) else
        if index <= 0 then element :: list else
            list.head :: insert(list.tail, element, index - 1)

@main def main = {
    def assertEquals[T](actualResult: T, expectedResult: T) = {
        if actualResult == expectedResult then print(s"TEST PASSED! ") else print(s"!!! TEST FAILED !!! ")
        println(s"expected result: $expectedResult, actual result: $actualResult")
    }

    println("TESTS:")

    assertEquals(reverse4(1, 2, 3, 4), (4, 3, 2, 1))
    assertEquals(reverse4("a", (), 5, List(0)), (List(0), 5, (), "a"))

    assertEquals(sumProd(1, 7), (21, 720))
    assertEquals(sumProd(-5, -1), (-14, 120))
    assertEquals(sumProd(5, 2), (0, 1))
    assertEquals(sumProd(-5, 6), (0, 0))

    assertEquals(isPerfect(1), false)
    assertEquals(isPerfect(2), false)
    assertEquals(isPerfect(4), false)
    assertEquals(isPerfect(6), true)
    assertEquals(isPerfect(12),false)
    assertEquals(isPerfect(28),true)
    assertEquals(isPerfect(64),false)
    assertEquals(isPerfect(496), true)
    assertEquals(isPerfect(4064), false)
    assertEquals(isPerfect(8128), true)
    assertEquals(isPerfect(-1),false)
    assertEquals(isPerfect(-6),false)
    assertEquals(isPerfect(0), false)

    assertEquals(insert(List(1, 2, 3, 4), 100, -4), List(100, 1, 2, 3, 4))
    assertEquals(insert(List(1, 2, 3, 4), 100, 0), List(100, 1, 2, 3, 4))
    assertEquals(insert(List(1, 2, 3, 4), 100, 1), List(1, 100, 2, 3, 4))
    assertEquals(insert(List(1, 2, 3, 4), 100, 3), List(1, 2, 3, 100, 4))
    assertEquals(insert(List(1, 2, 3, 4), 100, 4), List(1, 2, 3, 4, 100))
    assertEquals(insert(List(1, 2, 3, 4), 100, 10), List(1, 2, 3, 4, 100))
    assertEquals(insert(List(), 100, 0), List(100))
    assertEquals(insert(List(), 100, 15), List(100))
    assertEquals(insert(List(), 100, -15), List(100))
}
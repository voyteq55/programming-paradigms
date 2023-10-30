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
    if list == Nil then List[T](element) else
        if index <= 0 then element :: list else
            list.head :: insert(list.tail, element, index - 1)

def argmax(list: List[Int]) =
    def argmaxIndex(list: List[Int], index: Int): (List[Int], Int) = {
        if list == Nil then (Nil, Int.MinValue) else {
            val tailResult = argmaxIndex(list.tail, index + 1)
                if list.head < tailResult._2 then tailResult else
                    if list.head == tailResult._2 then (index :: tailResult._1, list.head) else
                        (List(index), list.head)
        }
    }
    argmaxIndex(list, 0)._1

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

    assertEquals(argmax(List()), List())
    assertEquals(argmax(List(1, 1, 1, 1, 1)), List(0, 1, 2, 3, 4))
    assertEquals(argmax(List(5, 4, 3, 2, 1)), List(0))
    assertEquals(argmax(List(4, 3, 2, 1, 5)), List(4))
    assertEquals(argmax(List(1, 2, 3, 4, 5)), List(4))
    assertEquals(argmax(List(1, 2, 5, 3, 4)), List(2))
    assertEquals(argmax(List(5, 1, 1, 2, 5, 3, 5)), List(0, 4, 6))
    assertEquals(argmax(List(1, 5, 1, 7, 3, 7, 2)), List(3, 5))
    assertEquals(argmax(List(-3)), List(0))
    assertEquals(argmax(List(1, 5, 3, 8, 2, 7, 8, 1)), List(3, 6))
}
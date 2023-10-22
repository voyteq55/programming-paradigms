def flatten[A](xss: List[List[A]]): List[A] =
  if xss.isEmpty then List() else
    xss.head ++ flatten (xss.tail)

def count[A](x:A, xs: List[A]): Int =
  if xs.length == 0 then 0 else
     if xs.head == x then (1 + count(x, xs.tail)) else count(x, xs.tail)

@main def ex01: Unit =
  def assertEquals[T](actualResult: T, expectedResult: T) = {
    if actualResult == expectedResult then print(s"TEST PASSED! ") else print(s"!!! TEST FAILED !!! ")
    println(s"expected result: $expectedResult, actual result: $actualResult")
  }

  println("TESTS:")

  assertEquals(flatten(List()), List())
  assertEquals(flatten(List(List(), List())), List())
  assertEquals(flatten(List(List(1, 2), List(3, 4))), List(1, 2, 3, 4))
  assertEquals(flatten(List(List(), List(), List(1), List(2, 3, 5))), List(1, 2, 3, 5))

  assertEquals(count(3, List(1, 2, 3, 4)), 1)
  assertEquals(count(List(List()), List(List(), List(), List(List(List())), List(List()), List(List()))), 2)
  assertEquals(count("a", List("a", "A", "a", "aaaaaaa", "b", "a")), 3)

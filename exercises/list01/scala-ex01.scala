def flatten[A](xss: List[List[A]]): List[A] =
  if xss.isEmpty then List() else
    xss.head ++ flatten(xss.tail)

def count[A](x:A, xs: List[A]): Int =
  if xs.length == 0 then 0 else
     if xs.head == x then (1 + count(x, xs.tail)) else count(x, xs.tail)

def replicate[A](x: A, n: Int): List[A] =
  if n == 0 then List() else
    x :: replicate(x, n - 1)

val sqrList: List[Int] => List[Int] = (list: List[Int]) =>
  if list == List() then List() else
    list.head * list.head :: sqrList(list.tail)

def isPalindrome[A](xs: List[A]): Boolean = {
  def reverse[A](xs: List[A]): List[A] = {
    def reverseRecursive[A](reversedList: List[A], originalList: List[A]): List[A] =
      if originalList.isEmpty then reversedList else
        reverseRecursive(originalList.head :: reversedList, originalList.tail)
    reverseRecursive(List(), xs)
  }
  xs == reverse(xs)
}

def listLength[A](xs: List[A]): Int =
  if xs.isEmpty then 0 else
    1 + listLength(xs.tail)

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

  assertEquals(replicate("aa", 5), List("aa", "aa", "aa", "aa", "aa"))
  assertEquals(replicate(List(), 2), List(List(), List()))
  assertEquals(replicate("aaaaa", 0), List())

  assertEquals(sqrList(List()), List())
  assertEquals(sqrList(List(1, 2, 3, -4)), List(1, 4, 9, 16))
  assertEquals(sqrList(List(0, -1, -2, -3)), List(0, 1, 4, 9))
  assertEquals(sqrList(List(5, 0, 0, 7, 7)), List(25, 0, 0, 49, 49))

  assertEquals(isPalindrome(List()), true)
  assertEquals(isPalindrome(List(())), true)
  assertEquals(isPalindrome(List(5, 5)),true)
  assertEquals(isPalindrome(List("a", "l")), false)
  assertEquals(isPalindrome(List("a", "l", "a")), true)
  assertEquals(isPalindrome(List("a", "b", "c", "c", "b", "a")), true)
  assertEquals(isPalindrome(List("a", "b", "c", "d", "c", "b", "a")), true)
  assertEquals(isPalindrome(List("a", "b", "c", "d", "c", "B", "a")), false)

  assertEquals(listLength(List()), 0)
  assertEquals(listLength(List(List(List()), List(), List(), List())), 4)
  assertEquals(listLength(List(100, 200, 300, 400, 500)), 5)
  assertEquals(listLength(List("a", "b", "c")), 3)

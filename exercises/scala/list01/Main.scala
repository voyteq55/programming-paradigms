@main def hello: Unit =
  println(count("ABC", List("ABFC", "ABC", "AAAA", "", "ABC")))
  println(count("", List()))
  
def count[A](x:A, xs: List[A]): Int =
  if xs.length == 0 then 0
  else if xs.head == x then (1 + count(x, xs.tail))
  else count(x, xs.tail)
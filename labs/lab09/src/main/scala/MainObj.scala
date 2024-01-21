object MainObj:
  def main(args: Array[String]): Unit =
    val r1 = new Rectangle(2, 4)
    val r2 = new Rectangle(7.5)
    println(r1)
    println(r2)

    r1.a = 10
    r2.b = 5
    println(r1)
    println(r2)

    // val rInvalid = new Rectangle(-1, 2)
    // r1.a = 0

    val splitter = new Splitter(40)
    splitter(r1)
    splitter(r2)
    splitter(new Rectangle(10))
    splitter(new Rectangle(2, 15))
    splitter.printSmallFigures()
    splitter.printLargeFigures()

    // val invalidSplitter = Splitter(-1)

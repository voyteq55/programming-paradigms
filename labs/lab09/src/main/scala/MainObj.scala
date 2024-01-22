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
    val r3 = new Rectangle(10)
    val r4 = new Rectangle(2, 15)
    splitter(r3)
    splitter(r4)
    splitter.printSmallFigures()
    splitter.printLargeFigures()

    // val invalidSplitter = Splitter(-1)

    val fineSplitter = new FineSplitter(40, 35, 45)
    fineSplitter(r1)
    fineSplitter(r2)
    fineSplitter(r3)
    fineSplitter(r4)

    fineSplitter.printSmallFigures()
    fineSplitter.printLargeFigures()
    fineSplitter.printMiddleFigures()

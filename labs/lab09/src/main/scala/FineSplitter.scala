import scala.collection.mutable.ListBuffer

class FineSplitter(smallestLargeFigureArea: Double, private val smallestMiddleFigureArea: Double, private val largestMiddleFigureArea: Double) extends Splitter(smallestLargeFigureArea):
  if smallestMiddleFigureArea <= 0 || largestMiddleFigureArea <= 0 then
    throw new IllegalArgumentException("Cut-off area must be positive")

  private val middleFigures: ListBuffer[Figure] = ListBuffer()

  override def apply(figureToAdd: Figure): Unit =
    super.apply(figureToAdd)
    if figureToAdd.area >= smallestMiddleFigureArea && figureToAdd.area <= largestMiddleFigureArea then
      middleFigures += figureToAdd

  def printMiddleFigures(): Unit =
    println(s"Middle figures: ${middleFigures.mkString(", ")}")

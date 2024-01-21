import scala.collection.mutable.ListBuffer

class Splitter(private val smallestLargeFigureArea: Double):
  if smallestLargeFigureArea <= 0 then throw new IllegalArgumentException("Cut-off area must be positive")

  private val smallFigures: ListBuffer[Figure] = ListBuffer()
  private val largeFigures: ListBuffer[Figure] = ListBuffer()

  def apply(figureToAdd: Figure): Unit =
    if figureToAdd.area >= smallestLargeFigureArea then
      largeFigures += figureToAdd else
      smallFigures += figureToAdd

  def printSmallFigures(): Unit =
    println(s"Small figures: ${smallFigures.mkString(", ")}")

  def printLargeFigures(): Unit =
    println(s"Large figures: ${largeFigures.mkString(", ")}")
    
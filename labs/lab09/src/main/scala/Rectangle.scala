class Rectangle(private var sideLengthA: Double, private var sideLengthB: Double) extends Figure:
  if sideLengthA <= 0 || sideLengthB <= 0 then throw new IllegalArgumentException("Rectangle sides must be positive numbers")

  def this(squareLength: Double) = this(squareLength, squareLength)

  def a: Double = sideLengthA

  def b: Double = sideLengthB

  def a_=(newSideLengthA: Double): Unit =
    if newSideLengthA <= 0 then throw new IllegalArgumentException("Rectangle side must be a positive number")
    sideLengthA = newSideLengthA

  def b_=(newSideLengthB: Double): Unit =
    if newSideLengthB <= 0 then throw new IllegalArgumentException("Rectangle side must be a positive number")
    sideLengthB = newSideLengthB

  override def area: Double = sideLengthA * sideLengthB

  override def toString: String = s"Rectangle with sides $a and $b, area of $area"

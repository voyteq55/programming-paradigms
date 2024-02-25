object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val timer1 = new Timer(5)
    val timer2 = new Timer(-3)
    println(timer1.hour)
    println(timer2.hour)
    timer1.hour = -5
    timer2.hour = 15
    println(timer1.hour)
    println(timer2.hour)
  }
}
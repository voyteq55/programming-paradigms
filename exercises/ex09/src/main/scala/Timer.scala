class Timer(private var h: Int) {
  if (h < 0) {
    h = 0
  }

  def hour: Int = h

  def hour_=(newHour: Int): Unit = {
    if (newHour < 0) {
      h = 0
    } else {
      h = newHour
    }
  }
}

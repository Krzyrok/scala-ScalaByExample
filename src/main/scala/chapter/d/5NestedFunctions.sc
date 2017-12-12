def sqrt(x: Double): Double = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double): Boolean =
    Math.abs(guess * guess - x) < 0.001

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  sqrtIter(1.0)
}

sqrt(4)


def sum(a: Int, b: Int, f: Int => Int): Int =
  if (a > b) 0 else f(a) + sum(a + 1, b, f)

def sumInts(a: Int, b: Int) = sum(a, b, x => x)
def sumSquares(a: Int, b: Int) = sum(a, b, x => x * x)

sumInts(2, 4)
sumSquares(1, 3)


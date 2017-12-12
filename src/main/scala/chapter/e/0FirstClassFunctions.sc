def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)

def square(a: Int) = a * a

def sumSquares(a: Int, b: Int): Int =
  if (a > b) 0 else square(a) + sumSquares(a + 1, b)


def powerOfTwo(n: Int): Int =
 if (n == 0) 1 else 2 * powerOfTwo(n - 1)


def sumPowersOfTwo(a: Int, b: Int): Int =
  if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)

def returnTheSame(n: Int) = n

def sum(a: Int, b: Int, f: Int => Int): Int =
  if (a > b) 0 else f(a) + sum(a + 1, b, f)

def sumInts2(a: Int, b: Int) = sum(a, b, returnTheSame)
def sumSquares2(a: Int, b: Int) = sum(a, b, square)
def sumPowersOfTwo2(a: Int, b: Int) = sum(a, b, powerOfTwo)

sumInts(2, 4)
sumInts2(2, 4)
sumSquares(1, 3)
sumSquares2(1, 3)
sumPowersOfTwo(1, 2)
sumPowersOfTwo2(1, 2)


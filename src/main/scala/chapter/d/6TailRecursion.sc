def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

gcd(14, 21)

def factorial(a: Int): Int = if (a == 0) 1 else a * factorial(a - 1)

factorial(4)

def factorialTailRecursive(n: Int): Int = {
  def factorial(accumulator: Int, n: Int): Int =
    if (n == 0) accumulator else factorial(n * accumulator, n - 1)

  factorial(1, n)
}

factorialTailRecursive(4)

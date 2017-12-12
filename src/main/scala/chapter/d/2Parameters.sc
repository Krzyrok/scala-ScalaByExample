def square(x: Double) = x * x
square(2)
square(3 + 5)
square(square(4))

def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
sumOfSquares(3, 2 + 2)

def loop: Int = loop
def first(x: => Int, y: => Int) = x // call-by-name instead of call-by-value
first(1, loop)

def constOne(x: Int, y: => Int) = 1
constOne(5, loop)

/*
Implement the factorial function using to and reduceLeft, without a loop or recursion
 */
object Factorial extends App {
  def factorial(n: Int): Int = {
    if (n < 1) 1
    else (1 to n).reduceLeft((x, y) => x * y)
  }

  println(factorial(5))
  println(factorial(2))
  println(factorial(1))
  println(factorial(0))
  println(factorial(-1))
}

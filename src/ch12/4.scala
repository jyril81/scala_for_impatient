/*
The previous implementation needed a special case when n < 1. Show how you can avoid this
with foldLeft. (Look at the Scaladoc for foldLeft. It’s like reduceLeft, except that the first value in
the chain of combined values is supplied in the call.)
 */
object FactorialFold extends App {
  def factorial(n: Int): Int = {
    (1 to n).foldLeft(1) { (x, y) => x * y }
  }

  println(factorial(5))
  println(factorial(2))
  println(factorial(1))
  println(factorial(0))
  println(factorial(-1))
}

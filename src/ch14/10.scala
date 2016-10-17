/*
10. Write a function that composes two functions of type Double => Option[Double], yielding another
function of the same type. The composition should yield None if either function does. For
example,
Click here to view code image
def f(x: Double) = if (x >= 0) Some(sqrt(Double)) else None
def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
val h = compose(f, g)
Then h(2) is Some(1), and h(1) and h(0) are None.
 */

object Compose extends App {
  def f(x: Double) = if (x >= 0) Some(math.sqrt(x)) else None

  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

  def compose(f: (Double) => Option[Double], g: (Double) => Option[Double]) = {
    (d: Double) => {
      f(d) match {
        case None => None
        case Some(v) => g(d)
      }
    }
  }

  val h = compose(f, g)
  println(h(2))
  println(h(1))
  println(h(0))

}

/*
2. Using pattern matching, write a function swap that receives a pair of integers and returns the pair
with the components swapped.
 */

object Swap extends App {
  def swap(pair: Tuple2[Int, Int]) = {
    pair match {
      case (x, y) => (y, x)
      //this will handle null input more gracefully, but will also make method inferred return type to java.io.serializable
      case _ => new IllegalArgumentException("Illegal input " + pair)
    }
  }

  println(swap((2, 3)))
  println(swap(null))
}
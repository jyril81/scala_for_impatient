/*
3. Using pattern matching, write a function swap that swaps the first two elements of an array
provided its length is at least two.
 */

import scala.reflect.ClassTag

object SwapArray extends App {

  def swap[T: ClassTag](arr: Array[T]) = {
    arr match {
      case Array(x, y) => Array(y, x)
      // note that binding nested variable rest is needed here to be able to properly define the right side of the expression
      case Array(x, y, rest@_*) => Array(y, x, rest)
    }
  }

  println(swap(Array(1, 2)).mkString(" "))
  println(swap(Array("one", "two", "three")).mkString(" "))
  println(swap(Array(1.4, 2.6, 3, 4.9)).mkString(" "))
}
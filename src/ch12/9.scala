/*
Implement corresponds without currying. Then try the call from the preceding exercise. What
problem do you encounter?
 */

import scala.language.postfixOps

object CorrespondsWithoutCurry extends App {
  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  val lengthsCorrect = Array(5, 5)
  val lengthsInCorrect = Array(1, 2, 3)


  def isWithLength(str: String, len: Int): Boolean = {
    if (str == null) false
    else str.length == len
  }

  def adjustToPair[A, B](f: (A, B) => Boolean): (Tuple2[A, B]) => Boolean = {
    t: (A, B) => f(t._1, t._2)
  }

  def corresponds[A, B](seq1: Seq[A], seq2: Seq[B], f: (A, B) => Boolean): Boolean = {
    (seq1 zip seq2) map adjustToPair(f) filter (_ == false) isEmpty
  }

  //does work when passing a function converted from a method
  println(corresponds(a, lengthsCorrect, isWithLength _))
  //does not work when passing anonymous function without explicit types
  //println(corresponds(a, lengthsCorrect, _.length == _))
  //will work as i pass anonymous function with explicit types
  println(corresponds(a, lengthsCorrect, (str: String, len: Int) => str.length == len))
}

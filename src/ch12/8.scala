/*
In Section 12.8, “Currying,” on page 149, you saw the corresponds method used with two arrays
of strings. Make a call to corresponds that checks whether the elements in an array of strings have
the lengths given in an array of integers.
 */

object CorrespondsCurry extends App {


  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  val lengthsCorrect = Array(5, 5)
  val lengthsInCorrect = Array(1, 2)

  println(a.corresponds(b)(_.equalsIgnoreCase(_)))
  //works when passing a function converted from method
  println(a.corresponds(lengthsCorrect)(isWithLength _))
  //works when passing anonymous function without types
  println(a.corresponds(lengthsCorrect)(_.length == _))

  def isWithLength(str: String, len: Int): Boolean = {
    if (str == null) false
    else str.length == len
  }
}

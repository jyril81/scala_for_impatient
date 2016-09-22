/*
How do you get the largest element of an array with reduceLeft?
 */
//reduceLeft takes a binary function to operate on collection values, from left to right
//in order to find largest element the binary function shoudl return largest of it's inputs

object Largest extends App {
  def largest(seq: Seq[Int]): Int = {
    seq.reduceLeft((x, y) => if (x > y) x else y)
  }

  println(largest(Array(3, 56, -3, 3423, 0, 23)))
  println(largest(Array(3)))
  println(largest(Array.empty[Int]))
}

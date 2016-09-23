/*
Modify the previous function to return the input at which the output is largest. For example,
largestAt(fun: (Int) => Int, inputs: Seq[Int]) should return 5. Don’t use a loop or recursion.
 */

import scala.language.postfixOps

object LargestAt extends App {
  //using just reduceLeft
  def largestAt1(fun: (Int) => Int, input: Seq[Int]): Int = {
    input.reduceLeft { (x, y) => if (fun(x) > fun(y)) x else y }
  }

  //second more complicated attempt to map first to pairs of input and fun output, and then reduce
  def largestAt2(fun: (Int) => Int, input: Seq[Int]): Int = {
    (input.map { (x) => (x, fun(x)) } reduceLeft { (t1: Tuple2[Int, Int], t2: Tuple2[Int, Int]) => if (t1._2 > t2._2) t1 else t2 })._1
  }

  println(largestAt1(x => 10 * x - x * x, 1 to 10))
  println(largestAt2(x => 10 * x - x * x, 1 to 10))
}

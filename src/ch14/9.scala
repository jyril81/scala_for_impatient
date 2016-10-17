/*
9. Write a function that computes the sum of the non-None values in a List[Option[Int]]. Don’t use a
match statement.
 */

object SumSomes extends App {
  val list = List(Option(1), Option.empty, Option(4), Option(5), Option.empty)

  //recursion
  def sumSomes1(list: List[Option[Int]]): Int = {
    if (list.isEmpty) 0
    else if (list.head.isEmpty) sumSomes1(list.tail)
    else list.head.get + sumSomes1(list.tail)
  }

  println(sumSomes1(list))

  //flatmap
  def sumSomes2(list: List[Option[Int]]): Int = {
    list.flatMap(e => e).sum
  }

  println(sumSomes2(list))

  //filter and map
  def sumSomes3(list: List[Option[Int]]): Int = {
    list.filter(o => !o.isEmpty).map(o => o.get).sum
  }

  println(sumSomes3(list))
}

/*
  5. Implement a function that works just like mkString, using reduceLeft.
   */

object MakeString extends App {

  def mkString[T](it: Iterable[T], sep: String): String = {
    if (it.isEmpty) "" else it.map(x => x.toString).reduceLeft((x, y) => x + sep + y)
  }

  println(mkString(Array.empty[Int], ", "))
  println(mkString(Array(1), ", "))
  println(mkString(Array(1, 2, 3), ", "))
}

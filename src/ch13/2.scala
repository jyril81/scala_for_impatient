/*
2. Repeat the preceding exercise, using an immutable map of characters to lists.
 */

import scala.collection.immutable.{List, Map}

object Indexes extends App {

  //List is ordered by definition
  def indexes(str: String) = {
    var map = Map[Char, List[Int]]()
    for (index <- 0 until str.length) {
      var lst = map.getOrElse(str.charAt(index), List.empty[Int]) :+ index
      map = map + (str.charAt(index) -> lst)
    }
    map
  }

  println(indexes("Mississippi"))
}

/*
1. Write a function that, given a string, produces a map of the indexes of all characters. For
example, indexes("Mississippi") should return a map associating 'M' with the set {0}, 'i' with the set
{1, 4, 7, 10}, and so on. Use a mutable map of characters to mutable sets. How can you ensure
that the set is sorted?
 */

import scala.collection.mutable.{Map, SortedSet}

object Indexes extends App {

  //use SortedSet to guarantee set order
  def indexes(str: String) = {
    val map = Map[Char, SortedSet[Int]]()
    for (index <- 0 until str.length) {
      val set = map.getOrElse(str.charAt(index), SortedSet.empty[Int]) += index
      map += (str.charAt(index) -> set)
    }
    map
  }

  println(indexes("Mississippi"))
}

/*
10. Harry Hacker reads a file into a string and wants to use a parallel collection to update the letter
frequencies concurrently on portions of the string. He uses the following code:
Click here to view code image
val frequencies = new scala.collection.mutable.HashMap[Char, Int]
for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1
Why is this a terrible idea? How can he really parallelize the computation? (Hint: Use
aggregate.)
 */

/**
  * Scala parallel collections do not support mutation of shared variables. The results are uppredictable.
  * To really parallelize the computation he could use following approaches.
  *
  */


/**
  * Use parallel collection with aggregate
  * This approach works with immutable colelctions and is quite slow, because it is always re-creating collections
  * for each mutating operation (in seqop and also in combop)
  */
object ParallelComputations extends App {
  val str = "Mississipi"

  //combop for aggregate. Merges two immutable maps so that counters for same key are added
  def mergeImmutableMaps(map1: collection.immutable.Map[Char, Int], map2: collection.immutable.Map[Char, Int]) = {
    map2.foldLeft(map1)((map: collection.immutable.Map[Char, Int], t: Tuple2[Char, Int]) => map + (t._1 -> (map.getOrElse(t._1, 0) + t._2)))
  }

  //pay attention to newlines when calling functons! https://issues.scala-lang.org/browse/SI-9723
  private val frequencis: Map[Char, Int] = str.par.aggregate(collection.immutable.Map[Char, Int]())(
    (map: Map[Char, Int], ch: Char) => map + (ch -> (map.getOrElse(ch, 0) + 1)),
    (map1: Map[Char, Int], map2: Map[Char, Int]) => mergeImmutableMaps(map1, map2)
  )


  println(frequencis)
}


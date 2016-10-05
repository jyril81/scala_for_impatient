/**
  * 4. Write a function that receives a collection of strings and a map from strings to integers. Return a
  * collection of integers that are values of the map corresponding to one of the strings in the
  * collection. For example, given Array("Tom", "Fred", "Harry") and Map("Tom" -> 3, "Dick" -> 4, "Harry" ->
  * 5), return Array(3, 5). Hint: Use flatMap to combine the Option values returned by get.
  */

object StringMapping extends App {

  //my initial solution
  def mapStrings(strings: Iterable[String], mapping: Map[String, Int]): Iterable[Int] = {
    strings.map(str => mapping.get(str))
      .filter(optInt => optInt.isDefined)
      .map(i => i.get)
  }

  //first attempt to use flatmap
  def mapStrings2(strings: Iterable[String], mapping: Map[String, Int]): Iterable[Int] = {
    strings.map(str => mapping.get(str))
      .flatMap(optInt => if (optInt.isDefined) Array(optInt.get) else Array.empty[Int])
  }

  //better use of flatmap
  //relies on the fact that if you use flatMap with a function that returns an Option, the resulting collection contains all
  //values v for which the function returns Some(v).
  def mapStrings3(strings: Iterable[String], mapping: Map[String, Int]): Iterable[Int] = {
    strings.map(str => mapping.get(str))
      .flatMap(optInt => optInt)
  }

  println(mapStrings(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))
  println(mapStrings2(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))
  println(mapStrings3(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))
}

/*
8. Write a function that turns an array of Double values into a two-dimensional array. Pass the
number of columns as a parameter. For example, with Array(1, 2, 3, 4, 5, 6) and three columns,
return Array(Array(1, 2, 3), Array(4, 5, 6)). Use the grouped method.
 */
object To2D extends App {

  def to2D(a: Array[Double], nrColumns: Int): Array[Array[Double]] = {
    a.grouped(nrColumns).toArray
  }

  private val to2d: Array[Array[Double]] = to2D(Array(1, 2, 3, 4, 5, 6), 3)
  to2d.foreach(a => println(a.mkString(" ")))
}

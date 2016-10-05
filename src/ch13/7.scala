/*
7. In Section 13.11, “Zipping,” on page 171, the expression (prices zip quantities) map { p => p._1 *
p._2 } is a bit inelegant. We can’t do (prices zip quantities) map { _ * _ } because _ * _ is a function
with two arguments, and we need a function with one argument that is a tuple. The tupled method
of the Function2 object changes a function with two arguments to one that takes a tuple. Apply
tupled to the multiplication function so you can map it over the list of pairs.
 */
object ZipTuples extends App {

  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)

  //from the book
  println((prices zip quantities) map { p => p._1 * p._2 })

  //will not compile
  //println((prices zip quantities) map { _ * _ })

  //using Function2.tupled
  //cannot use shorthand version of multiplication function because of type system constraints
  println((prices zip quantities) map (((x: Double, y: Int) => x * y).tupled))
}

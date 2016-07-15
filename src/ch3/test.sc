import scala.collection.mutable.ArrayBuffer

/*
Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect
indexes of the negative elements, reverse the sequence, drop the last index, and call a.remove(i)
for each index. Compare the efficiency of this approach with the two approaches in Section 3.4.
*/
def algorithm(a: ArrayBuffer[Int]) = {
  val negIndexes = for (i <- 0 until a.length if a(i) < 0) yield i
  println("negindexes " + negIndexes)
  val reversed = negIndexes.reverse
  println("negindexes reversed" + reversed)
  val ab: ArrayBuffer[Int] = ArrayBuffer[Int]()
  reversed.copyToBuffer(ab)
  ab.remove(ab.length-1)
  println("and last removed " + ab)
  for (i <-0 until ab.length) {
    a.remove(ab(i))
  }
 a
}
algorithm(ArrayBuffer(-1,2,3,-5))
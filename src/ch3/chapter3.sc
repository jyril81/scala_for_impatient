import java.util

import scala.collection.immutable.IndexedSeq
import scala.collection.mutable.ArrayBuffer
import scala.util.{Random, Sorting}

/*
1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n
(exclusive)
*/
def arrayGen(n: Int) = {
  for (e <- 0 until n) yield Random.nextInt(n)
}
val a: IndexedSeq[Int] = arrayGen(10)


/*
2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4,
5) becomes Array(2, 1, 4, 3, 5).
 */
def swapAdjecant(a: Array[Int]) = {
  for (i <- 0 until a.length - 1 by 2) {
    println("swapping " + a(i) + " and " + a(i + 1))
    val tmp = a(i)
    a(i) = a(i + 1)
    a(i + 1) = tmp
  }
  a
}
swapAdjecant(Array(1, 2, 3, 4, 5))
swapAdjecant((0 to 60).toArray)


/*
3. Repeat the preceding assignment, but produce a new array with the swapped values. Use
for/yield.
*/
def swapAdjecant2(a: Array[Int]) = {
  for (i <- 0 until a.length - 1 by 2) yield Array(a(i + 1), a(i))
}
swapAdjecant2(Array(1, 2, 3, 4, 5))


/*
4. Given an array of integers, produce a new array that contains all positive values of the original
array, in their original order, followed by all values that are zero or negative, in their original
order.
 */
//Solution1
def transform(a: Array[Int]) = {
  val result = ArrayBuffer[Int]()
  val nonPositives = ArrayBuffer[Int]()
  for (e <- a) {
    if (e > 0) {
      result.append(e)
    } else {
      nonPositives.append(e)
    }
  }
  result.appendAll(nonPositives)
  result.toArray
}
transform(Array(-1, -2, 3, -3))
transform(Array(-1, 1, 2, 3, -3))

//Solution 2
def transform2(a: Array[Int]) = {
  val result = new Array[Int](a.length)
  val nonPosIndexes = new Array[Int](a.length)
  var j = 0

  for (i <- 0 until a.length) {
    if (a(i) <= 0) {
      nonPosIndexes(j) = i
      //println("nonposindex at " + j + " set to " + nonPosIndexes(j))
      j += 1
    }
  }
  //println("nonposindexes=" + nonPosIndexes.toString)

  var k = 0
  for (e <- a) {
    if (e > 0) {
      result(k) = e
      //println("result att " + k + " st to " + result(k))
      k += 1
    }
  }
  for (i <- 0 until j) {
    result(k) = a(nonPosIndexes(i))
    //println("result at " + k + " st to " + result(k))
    k += 1
  }

  result
}
transform2(Array(-1, 1, 2, 3, -3))

//Solution 3
def transform3(a: Array[Int]) = {
  val ab = ArrayBuffer[Int]()
  a.copyToBuffer(ab)
  var index = 0
  for (i <- 0 until ab.length) {
    if (ab(index) <= 0) {
      val toRemove: Int = ab.remove(index)
      //println("Moving " + toRemove + " from index " + i + " to the end")
      ab.append(toRemove)
      //println("After removal "+  ab)
    } else {
      index += 1
    }
  }
  ab.toArray
}
transform3(Array(-1, -2, 3, -3))
transform3(Array(-1, 1, 2, 3, -3))

/*
5. How do you compute the average of an Array[Double]?
 */
def avg(a: Array[Double]) = {
  if (a.length == 0) {
    Double.NaN
  } else {
    a.sum / a.length
  }
}
avg(Array(1, 2, 3.45))
avg(Array())


/*
6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order?
How do you do the same with an ArrayBuffer[Int]?
 */
def rearrangeArray(a: Array[Int]) = {
  Sorting.quickSort(a)
  a.reverse
}
rearrangeArray(Array(2, 1, 3))

def rearrangeArrayBuffer(ab: ArrayBuffer[Int]) = {
  ab.sortWith(_ > _)
}
rearrangeArrayBuffer(ArrayBuffer(2, 1, 3))


/*
7. Write a code snippet that produces all values from an array with duplicates removed. (Hint:
Look at Scaladoc.)
*/
//Solution 1
def removeDuplicates(a: Array[Int]) = {
  a.distinct
}
removeDuplicates(Array(1, 2, 3, 2))

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
  ab.remove(ab.length - 1)
  println("and last removed " + ab)
  for (i <- 0 until ab.length) {
    a.remove(ab(i))
  }
  a
}
algorithm(ArrayBuffer(-1, 2, 3, -5))
//This is the worst approach since buffer is possibly shifted many times during the removals in final for loop.
//Also elements removed can be in any location of the buffer


/*
9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in
America. Strip off the "America/" prefix and sort the result.
 */
def listTimezonesOfAmerica = {
  val tzs = java.util.TimeZone.getAvailableIDs;
  tzs.filter(_ startsWith "America/")
    .map(_ substring 8)
    .sorted
}
listTimezonesOfAmerica


/*
10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
Click here to view code image
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the
return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of
java.util.List in the standard Java library.)
 */
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val buf: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)



import java.io.File
import java.util.Scanner

import scala.collection.immutable.{HashMap, SortedMap}
import scala.collection.mutable

/*
1. Set up a map of prices for a number of gizmos that you covet.
 Then produce a second map with the same keys and the prices at
 a 10 percent discount.
 */
val gizmos = HashMap("g1" -> 1.52, "g2" -> 4.52, "g3" -> 543.00)
val gizmosDiscounted = for ((gizmo, price) <- gizmos) yield (gizmo, 0.9 * price)

/*
2. Write a program that reads words from a file. Use a mutable map
to count how often each word
appears. To read the words, simply use a java.util.Scanner:
Click here to view code image
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) process in.next()
Or look at Chapter 9 for a Scalaesque way.
At the end, print out all words and their counts.
 */

def program(filename: String) = {
  val wordCounts = new mutable.HashMap[String, Int]()
  val in = new Scanner(new File(filename))
  while (in.hasNext()) {
    val word: String = in.next()
    wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
  }
  println(wordCounts)
}
program("C:\\Users\\jyril\\git\\impatient\\src\\ch4\\myfile.txt")

/*
3. Repeat the preceding exercise with an immutable map.
 */
def programImmutable(filename: String) = {
  var wordCounts = HashMap[String, Int]()
  val in = new Scanner(new File(filename))
  while (in.hasNext()) {
    val word: String = in.next()
    wordCounts = wordCounts + (word -> (wordCounts.getOrElse(word, 0) + 1))
  }
  println(wordCounts)
}
programImmutable("C:\\Users\\jyril\\git\\impatient\\src\\ch4\\myfile.txt")


/*
4. Repeat the preceding exercise with a sorted map, so that the words are printed
 in sorted order.
 */
def programImmutableSorted(filename: String) = {
  var wordCounts = SortedMap[String, Int]()
  val in = new Scanner(new File(filename))
  while (in.hasNext()) {
    val word: String = in.next()
    wordCounts = wordCounts + (word -> (wordCounts.getOrElse(word, 0) + 1))
  }
  println(wordCounts)
}
programImmutableSorted("C:\\Users\\jyril\\git\\impatient\\src\\ch4\\myfile.txt")


/*
5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
 */

import scala.collection.JavaConversions.mapAsScalaMap

def programImmutableSortedJavaAPI(filename: String) = {
  val wordCounts: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()
  val in = new Scanner(new File(filename))
  while (in.hasNext()) {
    val word: String = in.next()
    wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
  }
  println(wordCounts)
}
programImmutableSortedJavaAPI("C:\\Users\\jyril\\git\\impatient\\src\\ch4\\myfile.txt")


/*
Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY,
and similarly for the other
weekdays. Demonstrate that the elements are visited in insertion order.
 */
val weekDays = mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY,
  "Sunday" -> java.util.Calendar.SUNDAY
)
for ((k, v) <- weekDays) println((k, v))


/*
7. Print a table of all Java properties, like this:
Click here to view code image
java.runtime.name     | Java(TM) SE Runtime Environment
sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
java.vm.version       | 17.0-b16
java.vm.vendor        | Sun Microsystems Inc.
java.vendor.url       | http://java.sun.com/
path.separator        | :
java.vm.name          | Java HotSpot(TM) Server VM
You need to find the length of the longest key before you can print the table.
 */

import scala.collection.JavaConversions.propertiesAsScalaMap

val propertiesMap: scala.collection.Map[String, String] = System.getProperties

val maxKeyLength = propertiesMap.keys
  .map(_.length).max
for ((k, v) <- propertiesMap) {
  println(k + " " * (maxKeyLength - k.length) + " | " + v)
}

/*
8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest
values in the array.
 */
def minmax(values: Array[Int]) = {
  if (values.isEmpty) {
    ()
  } else {
    (values.min, values.max)
  }
}
minmax(Array(2, 5, 1))
minmax(Array(2))
minmax(Array())


/*
9. Write a function lteqgt(values: Array[Int], v: Int) that returns
a triple containing the counts of
values less than v, equal to v, and greater than v.
 */
def lteqgt(values: Array[Int], v: Int) = {
  var lt = 0
  var eq = 0
  var gt = 0
  for (e <- values) {
    if (e < v) {
      lt += 1
    } else if (e > v) {
      gt += 1
    } else {
      eq += 1
    }
  }
  (lt, eq, gt)
}
lteqgt(Array(7, 5, 3, 2), 5)


/*
10. What happens when you zip together two strings, such as "Hello".zip("World")? Come up with a
plausible use case.
 */
"Hello".zip("World")

//Use case for zipping to strings - simplistic encoding of alphabet, for example
//a -> az
//b -> by
//  ...


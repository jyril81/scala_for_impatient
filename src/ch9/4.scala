import scala.io.Source

/*
4. Write a Scala program that reads a text file containing only floating-point numbers. Print the
sum, average, maximum, and minimum of the numbers in the file.
 */
object PrintStats extends App {
  var count = 0
  var sum = 0d
  var average = 0d
  var max = 0d
  var min = 0d

  for (line <- Source.fromFile(args(0)).getLines()) {
    val asDouble = line.toDouble
    count += 1
    sum += asDouble
    if (max < asDouble) max = asDouble
    if (min > asDouble) min = asDouble
  }

  if (count > 0) {
    printf("sum=%f, average=%f, max=%f, min=%f", sum, sum / count, max, min)
  }
}
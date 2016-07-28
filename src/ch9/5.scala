import java.io.PrintWriter

/*
5. Write a Scala program that writes the powers of 2 and their reciprocals to a file, with the
exponent ranging from 0 to 20. Line up the columns:
1 1
2 0.5
4 0.25
...
*/

object PowersOf2 extends App {
  private val writer: PrintWriter = new PrintWriter(args(0))
  for (exp <- 0 to 20) {
    val pow: Double = math.pow(2, exp)
    writer.printf("%8.0f %s".format(pow, 1 / pow))
    writer.println()
  }
  writer.close()
}
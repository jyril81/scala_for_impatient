import scala.io.Source

/*
3. Write a Scala code snippet that reads a file and prints all words with more than 12 characters to
the console. Extra credit if you can do this in a single line.
 */
object OutputLongWords extends App {
  Source.fromFile(args(0))
    .getLines()
    .flatMap(_ split ("\\s+"))
    .filter(_.length > 12)
    .foreach(w => println(w))
}
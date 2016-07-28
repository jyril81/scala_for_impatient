import java.io.{File, PrintWriter}

import scala.io.{BufferedSource, Source}
import scala.util.Properties

/*
1. Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and
so on).
 */
object ReverseLines extends App {
  private val source: BufferedSource = Source.fromFile(args(0))
  private val reversedLines: List[String] = source.getLines().toList.reverse
  private val writer: PrintWriter = new PrintWriter(new File(args(0)))
  for (line <- reversedLines) {
    writer.append(line)
    writer.append(Properties.lineSeparator)
  }
  source.close()
  writer.close()
}

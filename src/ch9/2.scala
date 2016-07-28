import java.io.PrintWriter

import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

/*
2. Write a Scala program that reads a file with tabs, replaces each tab with spaces so that tab
stops are at n-column boundaries, and writes the result to the same file.
 */
object ReplaceTabs extends App {
  private val SPACE: String = " "
  private val TAB_REGEX: Regex = "\\t".r
  private val NR_SPACES_IN_TAB: Int = 8

  private val source: BufferedSource = Source.fromFile(args(0))
  private val processedList: List[String] = source.getLines()
    .map(line => {
      TAB_REGEX.replaceAllIn(line, SPACE * NR_SPACES_IN_TAB)
    })
    .toList
  private val writer: PrintWriter = new PrintWriter(args(0))
  for (line <- processedList) {
    writer.println(line)
  }
  source.close()
  writer.close()
}
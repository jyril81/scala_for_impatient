import scala.io.Source
import scala.util.matching.Regex

/*
8. Write a Scala program that prints the src attributes of all img tags of a web page. Use regular
expressions and groups.
 */

object ImageAttributes extends App {
  /**
    * Regex with groups where i need to extract middle part
    * 1. Prefix is everything until img src value starting point
    * 2. Followed by actual value within double quotes that im interested in
    * 3. followed by any suffix
    */

  private val regex: Regex = "(.*<img.* src=)(\"[^\"]+\")(.*)".r
  for (regex(prefix, srcValue, suffix) <- regex.findAllIn(Source.fromFile(args(0)).mkString)) {
    println(srcValue)
  }
}

//Usage
//scala ImageAttributes data.html
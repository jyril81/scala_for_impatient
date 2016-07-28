import scala.io.Source

/*
7. Write a Scala program that reads a text file and prints all tokens in the file that are not floatingpoint
numbers. Use a regular expression.
 */
object FindNumbers extends App {
  /** Floating point iteral regex
    * 1. one or more numbers
    * 2. followed by once or not at all: dot followed by one or more numbers
    * 3. followed by once or not at all: d or f
    */
  private val floatingPointLiteralRegex: String = "[0-9]+(\\.[0-9]+)?(d|f)?"
  private val tokens: Array[String] = Source.fromFile(args(0)).mkString.split("\\s+")
  for (token <- tokens) {
    if (!token.matches(floatingPointLiteralRegex)) {
      println("Found a NOT floating point token=" + token)
    }
  }
}

//Usage
//scala FindNumbers floating_tokens.txt
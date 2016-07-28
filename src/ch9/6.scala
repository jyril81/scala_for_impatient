import scala.io.Source

/*
6. Make a regular expression searching for quoted strings "like this, maybe with \" or \\" in a Java
or C++ program. Write a Scala program that prints out all such strings in a source file.
 */
object StringSearch extends App {
  private val contents: String = Source.fromFile(args(0)).mkString

  /**
    * 1. Opening double quote
    * 2. followed by zero or more symbols
    * 3. followed by closing double quote
    *
    */
  val regex = "\".*\"".r // or """ ".*" """
  for (item <- regex.findAllIn(contents)) {
    println(item)
  }
}

//Usage
//scala StringSearch java_source.java
import scala.collection.mutable.ArrayBuffer

/*
6. Provide a class ASCIIArt whose objects contain figures such as
 /\_/\
( ' ' )
(  -  )
 | | |
(__|__)
Supply operators for combining two ASCIIArt figures horizontally
 /\_/\    -----
( ' ' ) / Hello \
(  -  )|  Scala  |
 | | |  \ Coder /
(__|__)   -----
or vertically. Choose operators with appropriate precedence.
 */

//Vertical concat must be applies before horizontal contact because this is how lines in terminal are printed
//So Vertical concat operator must have higher precedence than horizontal operator
class ASCIIArt(val lines: Array[String]) {

  /**
    * Vertical concat. In resulting object other is placed on top of this
    *
    * @param other
    */
  def *(other: ASCIIArt) = {
    val resultLines = other.lines ++ lines
    println()
    ASCIIArt(resultLines)
  }

  /**
    * Horizontal concat. In resulting object other is placed on right of this
    */
  def +(other: ASCIIArt) = {
    val buf: ArrayBuffer[String] = ArrayBuffer[String]()

    val sharedLinesToAdd = scala.math.min(lines.length, other.lines.length)
    for (i <- 0 until sharedLinesToAdd) buf.append(lines(i) + other.lines(i))
    val longerLines = if (lines.length > other.lines.length) lines else other.lines
    for (i <- sharedLinesToAdd until longerLines.length) buf.append(longerLines(i))

    ASCIIArt(buf.toArray)
  }

  override def toString = {
    lines.mkString("\n")
  }

}

object ASCIIArt {

  def apply(lines: Array[String]) = {
    new ASCIIArt(lines)
  }

  def cat = {
    val lines: Array[String] = new Array[String](5)
    lines.update(0, " /\\_/\\ ")
    lines.update(1, "( ' ' )")
    lines.update(2, "(  -  )")
    lines.update(3, " | | | ")
    lines.update(4, "(__|__)")
    ASCIIArt(lines)
  }

  def message = {
    val lines: Array[String] = new Array[String](5)
    lines.update(0, "   -----   ")
    lines.update(1, " / Hello \\ ")
    lines.update(2, "|  Scala  |")
    lines.update(3, " \\ Coder / ")
    lines.update(4, "   -----   ")
    ASCIIArt(lines)
  }
}


object TestASCIIArt extends App {

  println("Creation")
  val cat = ASCIIArt.cat
  val msg = ASCIIArt.message
  println(cat)
  println(msg)
  println("Vertical concat once")
  println(cat * msg)
  println("Vertical concat twice")
  println(cat * cat * msg)

  println("Horizontal concat once")
  println(cat + msg)
  println("Horizontal concat twice")
  println(cat + cat + msg)

  println("Vertical and horizontal")
  println(cat + cat * msg)
  println("Horizontal and vertical")
  println((cat + cat) * msg)
}
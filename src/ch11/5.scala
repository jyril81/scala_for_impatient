import scala.collection.mutable.ArrayBuffer

/*
5. Provide operators that construct an HTML table. For example,

Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"

should produce

<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling...

 */
class Table {

  private val EMPTY_STRING = ""
  private val STARTTABLE = "<table>"
  private val ENDTABLE = "</table>"

  private val STARTROW = "<tr>"
  private val ENDROW = "</tr>"

  private val STARTCOL = "<td>"
  private val ENDCOL = "</td>"

  val htmlElements = ArrayBuffer[String]()

  /**
    * Add column to existing row
    *
    * @param col
    */
  def |(col: String) = {
    htmlElements.append(STARTCOL + col + ENDCOL)
    this
  }

  /**
    * Start new row with given column
    *
    * @param col
    * @return
    */
  def ||(col: String) = {
    htmlElements.append(ENDROW, STARTROW)
    htmlElements.append(STARTCOL + col + ENDCOL)
    this
  }

  override def toString = {
    val contents = if (htmlElements.isEmpty) {
      EMPTY_STRING
    }
    else {
      STARTROW + htmlElements.mkString(EMPTY_STRING) + ENDROW
    }
    STARTTABLE + contents + ENDTABLE
  }
}

object Table {

  def apply() = {
    new Table
  }
}

object TestTable extends App {
  println("Empty table=" + Table())
  println("Just 2 cols=" + (Table() | "Java" | "Scala"))
  println("Just 2 rows=" + (Table() || "Java" || "Scala"))
  println("Rows with different length=" + (Table() | "Java" | "Scala" || "Gosling"))
  println("Matrix table=" + (Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"))

}

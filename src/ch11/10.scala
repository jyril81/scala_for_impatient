/*
10. Define an unapplySeq operation for the RichFile class that extracts all path segments. For example,
for the file /home/cay/readme.txt, you should produce a sequence of three segments: home, cay, and
readme.txt.
*/

object RichFile {
  def unapplySeq(input: String): Option[Seq[String]] = {
    if (input.isEmpty) None else Some(input.split("/"))
  }

}

object TestUnapply extends App {

  val file = "/home/cay/readme.txt"


  file match {
    case RichFile(a, b, c) => println("a=" + a + ", b=" + b + ", c=" + c)
    case RichFile(a, b, c, d) => println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d)
    case RichFile(a, b) => println("a=" + a + ", b=" + b)
    case _ => println("Error")
  }

}

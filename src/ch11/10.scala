/*
10. Define an unapplySeq operation for the RichFile class that extracts all path segments. For example,
for the file /home/cay/readme.txt, you should produce a sequence of three segments: home, cay, and
readme.txt.
*/
class RichFile(val path: String, val name: String, val extension: String) {
  override def toString = {
    path + (if (path.endsWith("/")) "" else "/") + name + "." + extension
  }
}


object RichFile {
  val filePattern = "\\/(.*)\\/(.+)\\.(.+)".r

  def apply(path: String, name: String, extension: String) = {
    new RichFile(path, name, extension)
  }

  /*
  def unapply(fullName: String): Option[(String, String, String)] = {
    if (fullName == null || fullName.isEmpty) None
    else {
      val filePattern(p, n, e) = fullName
      Some(p, n, e)
    }
  }
  */

  def unapplySeq(input: String): Option[Seq[String]] = {
    if (input.isEmpty) None else Some(input.split("/"))
  }

}

object TestUnapply extends App {
  val f1 = RichFile("/home/cay", "readme", "txt")
  println(f1)
  println()

  val file = "/home/cay/readme.txt"


  file match {
    case RichFile(a, b, c) => println("a=" + a + ", b=" + b + ", c=" + c)
    case RichFile(a, b, c, d) => println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d)
    case RichFile(a, b) => println("a=" + a + ", b=" + b)
    case _ => println("Error")
  }

}

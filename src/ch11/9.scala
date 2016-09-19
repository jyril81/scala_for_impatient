/*
9. Define an unapply operation for the RichFile class that extracts the file path, name, and extension.
For example, the file /home/cay/readme.txt has path /home/cay, name readme, and extension txt.
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

  def unapply(fullName: String): Option[(String, String, String)] = {
    if (fullName == null || fullName.isEmpty) None
    else {
      val filePattern(p, n, e) = fullName
      Some(p, n, e)
    }
  }


}

object TestUnapply extends App {
  val f1 = RichFile("/home/cay", "readme", "txt")
  println(f1)
  println()

  val file = "/home/cay/readme.txt"
  file match {
    case RichFile(path, name, extension) => println("path=" + path + ", name=" + name + ", extension=" + extension)
    case _ => println("Error")
  }
}

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

  def unapply(fullName: String): Option[(String, String, String)] = {
    if (fullName == null || fullName.isEmpty) None
    else {
      val filePattern(p, n, e) = fullName
      Some(p, n, e)
    }
  }


}

object TestUnapply extends App {

  val file = "/home/cay/readme.txt"
  file match {
    case RichFile(path, name, extension) => println("path=" + path + ", name=" + name + ", extension=" + extension)
    case _ => println("Error")
  }
}

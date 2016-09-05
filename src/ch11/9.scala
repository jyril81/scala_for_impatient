/*
9. Define an unapply operation for the RichFile class that extracts the file path, name, and extension.
For example, the file /home/cay/readme.txt has path /home/cay, name readme, and extension txt.
 */
class RichFile(val path: String, val name: String, val extendsion: String) {
  override def toString = {
    path + (if (path.endsWith("/")) "" else "/") + name + "." + extendsion
  }
}


object RichFile {
  val filePattern = "(.*)".r

  def apply(path: String, name: String, extendsion: String) = {
    new RichFile(path, name, extendsion)
  }

  def unapply(fullName: String) = {
    //in form
    //*/
    filePattern.find
  }


}

object TestUnapply extends App {
  val f1 = RichFile("/home/cay", "readme", "txt")
  println(f1)
  println()

  val file = "/home/cay/readme.txt"
  val RichFile(path, name, extension) = file
  println("path=" + path + ", name=" + name + ", extendsion=" + extension)
}

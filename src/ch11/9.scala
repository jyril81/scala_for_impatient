/*
9. Define an unapply operation for the RichFile class that extracts the file path, name, and extension.
For example, the file /home/cay/readme.txt has path /home/cay, name readme, and extension txt.
 */

//Note how unapply and extraction has nothing to do with classes or instance construction
//no class definition is needed, no constructor is defined, no apply method is defined

object RichFile {
  val filePattern = "\\/(.*)\\/(.+)\\.(.+)".r

  def unapply(fullName: String): Option[(String, String, String)] = {
    if (fullName == null || fullName.isEmpty) None
    else {
      try {
        val filePattern(p, n, e) = fullName
        Some(p, n, e)
      } catch {
        case ex: Exception => None
      }
    }
  }


}

object TestUnapply extends App {

  val file = "/home/cay/readme.txt"
  //val file = "readme.txt"
  file match {
    case RichFile(path, name, extension) => println("path=" + path + ", name=" + name + ", extension=" + extension)
    case _ => println("Error")
  }
}

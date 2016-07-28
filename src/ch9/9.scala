import java.io.File

/*
9. Write a Scala program that counts how many files with .class extension are in a given directory
and its subdirectories.
 */
object CountClassFiles extends App {

  val src = new File(args(0))

  /*
    Count .class files in given dir
   */
  def countClassFiles(path: File) = {
    val classFiles: Array[File] = path.listFiles().filter(_ isFile)
      .filter(_.getName.endsWith(".class"))
    println("Class files for path=" + path + " are " + classFiles.mkString)
    classFiles.size
  }

  /**
    * Recursive method to get iterator of subdirs
    *
    */
  def allSubdirs(dir: File): Array[File] = {
    val subDirs: Array[File] = dir.listFiles().filter(_ isDirectory)
    //subdirs for given dir are all its direct subdirs concatenated with their subdirs
    subDirs ++ subDirs.flatMap(allSubdirs(_))
  }

  private val dirs: Array[File] = Array(src) ++ allSubdirs(src)

  private val sum: Int = dirs.map(countClassFiles(_)).sum
  println("Class file count=" + sum)

  //Usage
  //scla CountClassFiles .
}
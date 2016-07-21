

/*
6. Write a program that copies all elements from a Java hash map into a Scala hash map. Use
imports to rename both classes.
Move all imports into the innermost scope possible.
 */
object program extends App {

  def copyJavaMapToScalaMap = {
    import java.util.{HashMap => JavaHashMap}

    val javahm = new JavaHashMap[String, Int]()
    javahm.put("1", 1)
    javahm.put("2", 2)

    import scala.collection.mutable.{HashMap => ScalaHashMap}

    val scalahm = ScalaHashMap[String, Int]()

    //this is needed in order to treat java map as scala map operation wise
    import scala.collection.JavaConversions._

    for ((k, v) <- javahm) {
      scalahm.put(k, v)
    }
    println(scalahm)
  }

  copyJavaMapToScalaMap
}


/*
6. Write a program that copies all elements from a Java hash map into a Scala hash map. Use
imports to rename both classes.
 */
object program extends App {

  import java.util.{HashMap => JavaHashMap}

  import scala.collection.mutable.{HashMap => ScalaHashMap}

  //this is needed in order to treat java map as scala map operation wise
  import scala.collection.JavaConversions._

  val javahm = new JavaHashMap[String, Int]()
  javahm.put("1", 1)
  javahm.put("2", 2)
  val scalahm = ScalaHashMap[String, Int]()

  for ((k, v) <- javahm) {
    scalahm.put(k, v)
  }
  println(scalahm)
}
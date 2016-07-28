/*
10. Expand the example with the serializable Person class that stores a collection of friends.
Construct a few Person objects, make some of them friends of another, and then save an
Array[Person] to a file. Read the array back in and verify that the friend relations are intact.
 */

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

class Person(val name: String) extends Serializable {
  private val friends = new ArrayBuffer[Person] // OK—ArrayBuffer is serializable

  def addFriend(friend: Person) = {
    if (this != friend) {
      friends.append(friend)
    }
  }

  override def toString = {
    getClass + "[" + name + "] with friends=" + friends.map(_ name).toList
  }
}

object SerializationTest extends App {

  def save(persons: Array[Person], filename: String) = {
    val out: ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))
    out.writeObject(persons)
    out.close()
  }

  def load(filename: String): Array[Person] = {
    val in: ObjectInputStream = new ObjectInputStream(new FileInputStream(filename))
    val personsLoaded: Array[Person] = in.readObject().asInstanceOf[Array[Person]]
    in.close()
    personsLoaded
  }

  private val joe: Person = new Person("joe")
  private val jack: Person = new Person("jack")
  private val john: Person = new Person("john")

  joe.addFriend(jack)
  jack.addFriend(joe)
  john.addFriend(joe)

  private val persons: Array[Person] = Array(joe, jack, john)

  save(persons, args(0))

  private val loaded: Array[Person] = load(args(0))

  loaded.foreach((p: Person) => println(p toString))
}

//Usage
//scala SerializationTest friends.data
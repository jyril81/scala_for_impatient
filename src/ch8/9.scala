/*
9. In the Creature class of Section 8.10, “Construction Order and Early Definitions,” on page 92,
replace val range with a def. What happens when you also use a def in the Ant subclass? What
happens when you use a val in the subclass? Why?
 */
class Creature {
  def range: Int = 10

  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override def range = 2

  override def toString = {
    "range=" + range + "env.size =" + env.size
  }
}

object TestCreature extends App {
  val a = new Ant
  println(a)

  //val t = new Array[Int](10)
  //println(t.size)
}

//Replacing val range with def rnge in Creature clss does not change outcome
//Replacing override val range with override def range in Ant class (in addition to bov change)
//does change outcome, now env.size is 2 as needed
//The point is that val of subclass instance is not yet initialized when base class constructor runs
// so if base class ctor references some fields that migh be overridden in subclasses then
//it will work only if subclasses override with defs, because defs dont need special initialization
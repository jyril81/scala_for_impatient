/*
7. There are dozens of Scala trait tutorials with silly examples of barking dogs or philosophizing
frogs. Reading through contrived hierarchies can be tedious and not very helpful, but designing
your own is very illuminating. Make your own silly trait hierarchy example that demonstrates
layered traits, concrete and abstract methods, and concrete and abstract fields.
 */
//logger - done in book
//

trait AlcoholDrinker {
  val limit: Int

  def drink(millis: Int) = {
    if (millis <= limit) {
      println("Drinking " + name)
    } else println("Cannot drink " + name)
  }

  def name: String
}

trait BeerDrinker extends AlcoholDrinker {
  override val limit = 1000

  override def drink(millis: Int): Unit = {
    println("Attempting to drink beer")
    super.drink(millis)
  }

  override def name = {
    "Beer"
  }
}

trait WineDrinker extends AlcoholDrinker {
  override val limit = 300

  override def drink(millis: Int): Unit = {
    println("Attempting to drink wine")
    super.drink(millis)
  }

  override def name = {
    "Wine"
  }
}

trait VodkaDrinker extends AlcoholDrinker {
  override val limit = 50

  override def drink(millis: Int): Unit = {
    println("Attempting to drink vodka")
    super.drink(millis)
  }

  override def name = {
    "Vodka"
  }
}

class StrongToLightDrinker extends BeerDrinker with WineDrinker with VodkaDrinker

class LightToStrongDrinker extends VodkaDrinker with WineDrinker with BeerDrinker

//Output demonstrates that only one instance of AlcoholicDriker is constructed
//and allthough traits are executed from left to righ the same one underlying letfmost trait intance is always used
object TestDrinker extends App {
  private val d1: StrongToLightDrinker = new StrongToLightDrinker
  d1.drink(300)


  private val d2: LightToStrongDrinker = new LightToStrongDrinker
  d2.drink(300)
}
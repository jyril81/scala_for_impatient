/*
4. Add a case class Multiple that is a subclass of the Item class. For example, Multiple(10,
Article("Blackwell Toaster", 29.95)) describes ten toasters. Of course, you should be able to handle
any items, such as bundles or multiples, in the second argument. Extend the price function to
handle this new case.
 */
object TestMultiple extends App {

  abstract class Item

  case class Article(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  case class Multiple(multiple: Int, it: Item) extends Item

  def price(it: Item): Double = {
    it match {
      case Article(_, p) => p
      //note that Bundle(_, discount, items) wont work, it tries to match variable items as one Item
      //case Bundle(_, discount, items) => items.map(price(_)).sum - discount
      case Bundle(_, discount, items@_*) => items.map(price(_)).sum - discount
      case Multiple(m, it) => m * price(it)
    }
  }

  println(
    price(
      Bundle("Father's day special", 20.0,
        Article("Scala for the Impatient", 39.95),
        Bundle("Anchor Distillery Sampler", 10.0,
          Article("Old Potrero Straight Rye Whiskey", 79.95),
          Article("Junípero Gin", 32.95)))
    ))
  println(
    price(
      Bundle("Father's day special", 20.0,
        Article("Scala for the Impatient", 39.95),
        Multiple(10,
          Article("Junípero Gin", 32.95)))
    )
  )
}
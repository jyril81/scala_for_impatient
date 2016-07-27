import scala.collection.mutable.ArrayBuffer

/*
4. Define an abstract class Item with methods price and description. A SimpleItem is an item whose
price and description are specified in the constructor. Take advantage of the fact that a val can
override a def. A Bundle is an item that contains other items. Its price is the sum of the prices in
the bundle. Also provide a mechanism for adding items to the bundle and a suitable description
method.
 */
abstract class Item {
  def price: Double

  def description: String
}

class SimpleItem(override val price: Double, override val description: String)
  extends Item {
  override def toString = {
    "Item[price=" + this.price + ", description=" + this.description + "]"
  }
}

class Bundle extends Item {
  private var items = new ArrayBuffer[Item]()

  override def price: Double = {
    items.map(_.price)
      .sum
  }

  override def description: String = {
    "Bundle with items [" + items + "]"
  }

  def addItem(item: Item) = {
    items.append(item)
  }

}

object test4 extends App {
  val b = new Bundle
  b.addItem(new SimpleItem(1.2, "fish"))
  b.addItem(new SimpleItem(12.5, "beer"))
  println(b.price)
  println(b.description)
}
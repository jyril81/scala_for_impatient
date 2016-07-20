import java.awt.Point

/*
1. Write an object Conversions with methods
inchesToCentimeters, gallonsToLiters, and milesToKilometers.
*/
object Conversions {
  def inchesToCentimeters(inches: Double) = {
    inches * 2.54
  }

  def gallonsToLiters(gallons: Double) = {
    gallons * 3.785
  }

  def milesToKilometers(miles: Double) = {
    miles * 1.609
  }
}

Conversions.inchesToCentimeters(5.3)
Conversions.gallonsToLiters(10)
Conversions.milesToKilometers(2.5)


/*
2. The preceding problem wasn’t very object-oriented.
Provide a general superclass UnitConversion and define objects
 InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
 */
abstract class UnitConversion {
  def convert(source: Double): Double
}

object InchesToCentimeters extends UnitConversion {
  override def convert(source: Double): Double = {
    source * 2.54
  }
}

InchesToCentimeters.convert(5.3)

object GallonsToLitres extends UnitConversion {
  override def convert(source: Double): Double = {
    source * 3.785
  }
}

GallonsToLitres.convert(10)

object MilesToKilometers extends UnitConversion {
  override def convert(source: Double): Double = {
    source * 1.609
  }
}

MilesToKilometers.convert(2.5)


/*
3. Define an Origin object that extends java.awt.Point.
 Why is this not actually a good idea? (Have a close look at the methods of the Point class.)
 */
object Origin extends Point(0, 0)

Origin
//The problem is that Point is mutable and thus
//Origin is not really origin anymore
Origin.setLocation(3, 5)
Origin


/*
4. Define a Point class with a companion object so that you
can construct Point instances as Point(3,4), without using new.
 */
class MyPoint private(val x: Int, val y: Int) {
  override def toString: String = {
    "MyPoint(" + x + ", " + y + ")"
  }
}

object MyPoint {
  def apply(x: Int, y: Int) = {
    new MyPoint(x, y)
  }
}

MyPoint(3, 4)


/*
6. Write an enumeration describing the four playing card suits so that
 the toString method returns ♣, ♦, ♥, or ♠.
 */
object Suits extends Enumeration {
  val Clubs = Value("♣")
  val Diamonds = Value("♦")
  val Hearts = Value("♥")
  val Spades = Value("♠")
}


/*
7. Implement a function that checks whether a card suit
 value from the preceding exercise is red.
 */
def isRed(suit: Suits.Value) = {
  if (suit == Suits.Hearts || suit == Suits.Diamonds) true
  else false
}
isRed(Suits.Hearts)
isRed(Suits.Clubs)


/*
8. Write an enumeration describing the eight corners of the RGB color
 cube. As IDs, use the color values (for example, 0xff0000 for Red).
 */
object RGBCube extends Enumeration {
  val Red = Value(0xff0000)
  val Yellow = Value(0xffff00)
  val Green = Value(0x008000)
  val Black = Value(0x000000)
  val White = Value(0xffffff)
  val Cyan = Value(0x00ffff)
  val Magenta = Value(0xff00ff)
  val Blue = Value(0x0000ff)
}

for (color <- RGBCube.values) println(color)
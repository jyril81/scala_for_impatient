/*
3. Consult your favorite Java or C++ textbook that is sure to have an example of a toy inheritance
hierarchy, perhaps involving employees, pets, graphical shapes, or the like. Implement the
example in Scala.
 */
//Implementing shapes example given at
// http://courses.cs.washington.edu/courses/cse143/06su/chapters/ch9.html

abstract class Shape(protected val origin: java.awt.Point) {

  def getArea: Double

  def getPerimeter: Double
}

class Circle(center: java.awt.Point, private val radius: Double)
  extends Shape(center) {
  private val PI: Double = 3.14156

  override def getArea: Double = {
    PI * math.pow(radius, 2)
  }

  override def getPerimeter: Double = {
    2 * PI * radius
  }
}

class Rectangle(origin: java.awt.Point, private val width: Double, private val height: Double)
  extends Shape(origin) {
  override def getArea: Double = {
    width * height
  }

  override def getPerimeter: Double = {
    2 * (width + height)
  }
}

class Square(leftButtom: java.awt.Point, private val size: Int)
  extends Rectangle(leftButtom, size, size) {

  override def toString: String = {
    "origin=" + this.origin
  }
}

//test our hierarchy
object test extends App {
  val circle = new Circle(new java.awt.Point(), 3)
  val rectangle = new Rectangle(new java.awt.Point(3, 4), 5, 10)
  val square = new Square(new java.awt.Point(12, 23), 10)

  println(circle.getArea)
  println(circle.getPerimeter)

  println(rectangle.getArea)
  println(rectangle.getPerimeter)

  println(square.getArea)
  println(square.getPerimeter)

  println(square)
}
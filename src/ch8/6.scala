import java.awt.Point

/*
6. Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and
Circle. Provide appropriate constructors for the subclasses and override the centerPoint method in
each subclass.
 */
abstract class Shape(val origin: Point) {
  def centerPoint: Point
}

class Rectangle(o: Point, val width: Double, val height: Double)
  extends Shape(o) {
  override def centerPoint: Point = {
    new Point(origin.x + width / 2, origin.y + height / 2)
  }
}

class Circle(o: Point, val radius: Double) extends Shape(o) {
  override def centerPoint(): Point = {
    origin
  }
}

object TestCenterPoints extends App {
  private val origin: Point = new Point(0, 0)
  val r = new Rectangle(origin, 20, 10)
  val c = new Circle(origin, 5)
  println("origin=" + origin + ", r.centerPoint=" + r.centerPoint + ", c.centerPoint=" + c.centerPoint)
}
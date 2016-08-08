import java.awt.Point

/*
2. Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point. Use lexicographic
ordering, i.e. (x, y) < (x’, y’) if x < x’ or x = x’ and y < y’.
 */
class OrderedPoint(x: Int, y: Int) extends Point(x, y) with Ordered[Point] {
  override def compare(that: Point): Int = {
    if (x < that.x) -1
    else if (x == that.x && y < that.y) -1
    else if (x == that.x && y == that.y) 0
    else 1
  }
}

object TestOrderedPoint extends App {
  private val p1 = new OrderedPoint(1, 2)
  private val p2 = new OrderedPoint(1, 5)
  private val p3 = new OrderedPoint(1, 5)

  println(p1 < p2)
  println(p2 == p3)
}
/*
5. Design a class Point whose x and y coordinate values can be provided in a constructor. Provide
a subclass LabeledPoint whose constructor takes a label value and x and y coordinates, such as
Click here to view code image
new LabeledPoint("Black Thursday", 1929, 230.07)
 */
class Point(val x: Double, val y: Double) {
  override def toString: String = {
    this.getClass + "[x=" + x + ",y=" + y + "]"
  }
}

class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
  override def toString: String = {
    super.toString + " with label=" + label
  }
}

object TestPoints extends App {
  println(new LabeledPoint("Black Thursday", 1929, 230.07))
}
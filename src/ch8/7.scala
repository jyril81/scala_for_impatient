/*
7. Provide a class Square that extends java.awt.Rectangle and has three constructors: one that
constructs a square with a given corner point and width, one that constructs a square with corner
(0, 0) and a given width, and one that constructs a square with corner (0, 0) and width 0.
 */

import java.awt.Rectangle

class Square(x: Int, y: Int, width: Int) extends Rectangle(x, y, width, width) {

  def this() = {
    this(0, 0, 0)
  }

  def this(width: Int) = {
    this(0, 0, width)
  }
}

object TestSquare extends App {
  println(new Square())
  println(new Square(5))
  println(new Square(3, 3, 5))
}
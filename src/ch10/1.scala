import java.awt.geom.Ellipse2D
import java.awt.{Dimension, Point}

/*
1. The java.awt.Rectangle class has useful methods translate and grow that are unfortunately absent
from classes such as java.awt.geom.Ellipse2D. In Scala, you can fix this problem. Define a trait
RectangleLike with concrete methods translate and grow. Provide any abstract methods that you need
for the implementation, so that you can mix in the trait like this:
Click here to view code image
val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.translate(10, -10)
egg.grow(10, 20)
 */
trait RectangleLike {
  /**
    * Translates this <code>RectangleLike</code> the indicated distance,
    * to the right along the X coordinate axis, and
    * downward along the Y coordinate axis.
    *
    * @param dx the distance to move this <code>Rectangle</code>
    *           along the X axis
    * @param dy the distance to move this <code>Rectangle</code>
    *           along the Y axis
    * @see java.awt.Rectangle#setLocation(int, int)
    * @see java.awt.Rectangle#setLocation(java.awt.Point)
    */
  def translate(dx: Int, dy: Int) = {
    setLocation(new Point(getLocation.x + dx, getLocation.y - dy))
  }

  /**
    * Resizes the <code>RectangleLike</code> both horizontally and vertically.
    * <p>
    * This method modifies the <code>RectangleLike</code> so that it is
    * <code>h</code> units larger on both the left and right side,
    * and <code>v</code> units larger at both the top and bottom.
    * <p>
    * The new <code>RectangleLike</code> has {@code (x - h, y - v)}
    * as its upper-left corner,
    * width of {@code (width + 2h)},
    * and a height of {@code (height + 2v)}.
    * <p>
    *
    * @param h the horizontal expansion
    * @param v the vertical expansion
    */
  def grow(h: Int, v: Int) = {
    setLocation(new Point(getLocation.x, getLocation.y))
    setDimension(new Dimension(getDimension.width * 2, getDimension.height * 2))
  }

  /**
    * Set upper left point
    *
    * @param x
    * @param y
    */
  def setLocation(upperLeft: Point): Unit

  /**
    * Get upper letf point
    *
    * @return
    */
  def getLocation: Point

  /**
    * Set dimension
    *
    * @param x
    * @param y
    */
  def setDimension(dim: Dimension): Unit

  /**
    * Get dimension
    *
    * @return
    */
  def getDimension: Dimension
}


object TestRectangleLike extends App {
  val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike {
    /**
      * Set upper left point
      *
      * @param x
      * @param y
      */
    override def setLocation(upperLeft: Point): Unit = {
      setFrame(upperLeft, getDimension)
    }

    /**
      * Get upper letf point
      *
      * @return
      */
    override def getLocation: Point = {
      new Point(getX.toInt, getY.toInt)
    }

    /**
      * Set dimension
      *
      * @param x
      * @param y
      */
    override def setDimension(dim: Dimension): Unit = {
      setFrame(getLocation, dim)
    }

    /**
      * Get dimension
      *
      * @return
      */
    override def getDimension: Dimension = {
      new Dimension(getWidth.toInt, getHeight.toInt)
    }
  }
  egg.translate(10, -10)
  egg.grow(10, 20)
}
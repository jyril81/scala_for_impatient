import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport}

/*
5. The JavaBeans specification has the notion of a property change listener, a standardized way
for beans to communicate changes in their properties. The PropertyChangeSupport class is provided
as a convenience superclass for any bean that wishes to support property change listeners.
Unfortunately, a class that already has another superclass—such as JComponent—must reimplement
the methods. Reimplement PropertyChangeSupport as a trait, and mix it into the java.awt.Point class.
 */
trait MyPropertyChangeSupport {
  val propertyChangeSupport: PropertyChangeSupport = new PropertyChangeSupport(this)

  def addChangeListener(propertyChangeListener: PropertyChangeListener) = {
    propertyChangeSupport.addPropertyChangeListener(propertyChangeListener)
  }

  def removeChangeListener(propertyChangeListener: PropertyChangeListener) = {
    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener)
  }

  def propertyChanged(name: String, oldValue: Any, newValue: Any) = {
    propertyChangeSupport.firePropertyChange(name, oldValue, newValue)
  }

}

object TestPropertyChanges extends App {
  private val p: Point with MyPropertyChangeSupport = new java.awt.Point(1, 2) with MyPropertyChangeSupport {
    override def setLocation(another: Point): Unit = {
      val old: Point = getLocation
      super.setLocation(another)
      propertyChanged("location", old, another)
    }
  }

  println(p)
  p.addChangeListener(new PropertyChangeListener {
    override def propertyChange(evt: PropertyChangeEvent): Unit = {
      println("Property " + evt.getPropertyName + "  value changed from " + evt.getOldValue + " to " + evt.getNewValue)
    }
  })

  p.setLocation(new Point(1, 5))

}
/*
Example 2 which will not compile as well, because we import
package jyril members to scope and again relative referencing occurs
*/

package jyril.com {}

package test {

  import jyril._

  object o {
    val b = com.sun.awt.AWTUtilities.isWindowShapingSupported
  }

}
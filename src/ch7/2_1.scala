/*
Example 1 which will not compile with previously defined package.
Iissue is that scala support referencing by relative path and thus
com is expected as jyril.com here because we are in jyril package
 */
package jyril.com {}


package jyril {

  object o {
    val b = com.sun.awt.AWTUtilities.isWindowShapingSupported
  }

}
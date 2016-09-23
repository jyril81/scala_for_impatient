/*
Implement an unless control abstraction that works just like if, but with an inverted condition.
Does the first parameter need to be a call-by-name parameter? Do you need currying?
 */

object Unless extends App {

  //First attempt do use standard notation without call by name
  def unless1(cond: () => Boolean, block: () => Unit): Unit = {
    if (!cond()) block()
  }

  //Will not compile because both arguments are evaluated before unless executes, so type mismatch is detected
  //unless1(1 == 2, println("Works"))


  //second attempt with call by name syntax
  def unless2(cond: => Boolean, block: => Unit): Unit = {
    if (!cond) block
  }

  //this will work
  unless2(1 == 2, println("Works"))

  //third attempt with added currying
  def unless(cond: => Boolean)(block: => Unit): Unit = {
    if (!cond) block
  }

  //works and looks better in calling code
  unless(1 == 2) {
    println("Works even better")
  }

  //To conclude currying is optional but call by name is mandatory when implementing control structures
}

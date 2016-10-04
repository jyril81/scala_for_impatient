import scala.collection.mutable.LinkedList

/**
  * 3. Write a function that removes all zeroes from a linked list of integers.
  */

object RemoveZeroes extends App {
  println("**********ITERATIVE**********")
  val lst = LinkedList(0, 3, 4, 0, -2344, 354, 0)
  println("Initial list=" + lst)
  println("Return value from removal=" + removeZeroesIterative(lst))
  println("Initial list after removal=" + lst)
  //just for testing
  println("With empty list=" + removeZeroesIterative(LinkedList.empty[Int]))
  println("With one zero element=" + removeZeroesIterative(LinkedList(0)))

  println("**********RECURSIVE**********")
  val lst2 = LinkedList(0, 3, 4, 0, -2344, 354, 0)
  println("Initial list=" + lst2)
  println("Return value from removal=" + removeZeroesRecursive(lst2))
  println("Initial list after removal=" + lst2)
  //just for testing
  println("With empty list=" + removeZeroesRecursive(LinkedList.empty[Int]))
  println("With one zero element=" + removeZeroesRecursive(LinkedList(0)))

  /**
    * Iterative solution. Modifies given argument
    *
    * @param lst
    * @return lst
    */
  def removeZeroesIterative(lst: LinkedList[Int]) = {
    //new head for return value
    var first = lst
    //current node in traversal
    var cur = lst
    if (lst.isEmpty) first
    else {
      //keep removing zeroes from the beginning
      while (cur != Nil && cur.elem == 0) {
        cur = cur.drop(1)
        if (cur != Nil) {
          first.elem = cur.elem
          first.next = cur.next
        } else {
          first = LinkedList.empty[Int]
        }
      }
      //now first elem is not zero
      while (cur != Nil && cur.next != Nil) {
        if (cur.next.elem == 0) {
          cur.next = cur.next.next
        }
        cur = cur.next
      }
      first
    }
  }

  /**
    * Recursive solution
    * Does not modify given list
    *
    * @param lst
    * @return
    */
  def removeZeroesRecursive(lst: LinkedList[Int]): LinkedList[Int] = {
    if (lst.isEmpty) lst
    else if (lst.elem == 0) removeZeroesRecursive(lst.tail)
    else lst.head +: removeZeroesRecursive(lst.tail)
  }

}

/*
5. One can use lists to model trees that store values only in the leaves. For example, the list ((3 8)
2 (5)) describes the tree
•
/|\
• 2 •
/ \ |
3 8 5
However, some of the list elements are numbers and others are lists. In Scala, you cannot
have heterogeneous lists, so you have to use a List[Any]. Write a leafSum function to compute
the sum of all elements in the leaves, using pattern matching to differentiate between
numbers and lists.
 */

object ListTree extends App {
  //idea is to recurse as general algorithm and use pattern matching to differentiate between numbers and lists

  def leafSum(lst: List[Any]): Int = {
    if (lst.isEmpty) 0
    else {
      val headValue = lst.head match {
        case x: Int => x
        case l: List[_] => leafSum(l)
      }
      headValue + leafSum(lst.tail)
    }
  }

  println(leafSum(List((3 8) 2 (5)) ) )
}
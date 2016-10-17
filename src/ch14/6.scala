/*
6. A better way of modeling such trees is with case classes. Let’s start with binary trees.
Click here to view code image
sealed abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
Write a function to compute the sum of all elements in the leaves.
 */
sealed abstract class BinaryTree

case class Leaf(value: Int) extends BinaryTree

case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

object BinaryTreeTest extends App {

  def leafSum(t: BinaryTree): Int = {
    t match {
      case Leaf(v) => v
      case Node(l, r) => leafSum(l) + leafSum(r)
    }
  }

  println(leafSum(Node(Node(Leaf(3), Leaf(8)), Node(Leaf(5), Leaf(6)))))
}

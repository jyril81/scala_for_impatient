/*
7. Extend the tree in the preceding exercise so that each node can have an arbitrary number of
children, and reimplement the leafSum function. The tree in exercise 5 should be expressible as
Click here to view code image
Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
 */
sealed abstract class Tree

case class Leaf(value: Int) extends Tree

case class Node(children: Tree*) extends Tree

object TreeTest extends App {
  def leafSum(tree: Tree): Int = {
    tree match {
      case Leaf(v) => v
      case Node(children@_*) => children.map(leafSum(_)).sum
    }
  }

  println(leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))))
}

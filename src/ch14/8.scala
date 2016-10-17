/*
8. Extend the tree in the preceding exercise so that each non-leaf node stores an operator in
addition to the child nodes. Then write a function eval that computes the value. For example, the
tree
+
/|\
* 2 -
/ \ |
3 8 5
has value (3 × 8) + 2 + (–5) = 21
 */

//Provide exhaustive list of possible operators
sealed abstract class Op

case object PLUS extends Op

//for one operand acts as negate, for multiple operands acts as minus operator
case object MINUS extends Op

case object MULT extends Op


sealed abstract class Tree

case class Leaf(value: Int) extends Tree

case class Node(op: Op, children: Tree*) extends Tree


object OpTreeTest extends App {
  def eval(tree: Tree): Int = {
    tree match {
      case Leaf(v) => v
      case Node(PLUS, children@_*) => children.map(eval _).reduceLeft(_ + _)
      //notice foldLeft with initial value to support one operand negation
      case Node(MINUS, children@_*) => children.map(eval _).foldLeft(0)(_ - _)
      case Node(MULT, children@_*) => children.map(eval _).reduceLeft(_ * _)
    }
  }

  println(eval(Node(PLUS, Node(MULT, Leaf(3), Leaf(8)), Leaf(2), Node(MINUS, Leaf(5)))))
}

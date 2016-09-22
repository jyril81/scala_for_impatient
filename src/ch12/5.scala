/*
Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest value of a
function within a given sequence of inputs. For example, largest(x => 10 * x - x * x, 1 to 10)
should return 25. Don’t use a loop or recursion.
 */
object LargestFromSeq extends App {
  def largest(fun: (Int) => Int, input: Seq[Int]) = {
    fun(input.reduceLeft({ (x, y) => if (fun(x) > fun(y)) x else y }))
  }

  println(largest(x => 10 * x - x * x, 1 to 10))
}

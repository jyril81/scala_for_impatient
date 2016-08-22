/*
8. Provide a class Matrix—you can choose whether you want to implement 2 × 2 matrices, square
matrices of any size, or m × n matrices. Supply operations + and *. The latter should also work
with scalars, for example mat * 2. A single element should be accessible as mat(row, col).
 */

class Matrix(val data: Array[Array[Int]]) {

  if (data == null) throw new IllegalArgumentException("Missing data")

  private var rowLength = 0
  for (i <- 0 until data.length - 1) {
    rowLength = data(i).length
    if (rowLength != data(i + 1).length) throw new IllegalArgumentException("All rows must have same length")
  }

  def dim = {
    (data.length, if (data.length > 0) data(0).length else data.length)
  }

  def apply(row: Int, col: Int) = {
    data(row)(col)
  }

  def +(summand: Matrix) = {
    if (dim != summand.dim) throw new IllegalArgumentException("Cannot add matrixes with different dimensions")

    var sum = Array.ofDim[Int](dim._1, dim._2)
    for (i <- 0 until data.length) {
      for (j <- 0 until data(i).length) {
        sum(i)(j) = apply(i, j) + summand(i, j)
      }
    }
    Matrix(sum)
  }

  def *(multiplier: Matrix) = {
    var nrColumns = if (data.length > 0) data(0).length else 0
    if (nrColumns != multiplier.data.length) throw new IllegalArgumentException("Left side matrix nrCols must be same as righ side matrix nrRows")

    var product = Array.ofDim[Int](dim._1, multiplier.dim._2)
    for (i <- 0 until data.length) {
      for (j <- 0 until multiplier.data(i).length) {
        product(i)(j) = Matrix.multiply(data(i), multiplier.data, j)
      }
    }
    Matrix(product)
  }

  def *(scalar: Int) = {
    var product = Array.ofDim[Int](dim._1, dim._2)
    for (i <- 0 until data.length) {
      for (j <- 0 until data(i).length) {
        product(i)(j) = scalar * data(i)(j)
      }
    }
    Matrix(product)
  }

  override def toString = {
    val sb = StringBuilder.newBuilder
    for (i <- 0 until data.length) {
      sb.append("[" + data(i).mkString(" ") + "]" + "\n")
    }
    sb.toString
  }

}

object Matrix {
  /**
    *
    * @param a1
    * @param a2
    * @param index
    * @return sum of all elements in a1 multiplied by all elements in index'th column in a2
    */
  def multiply(a1: Array[Int], a2: Array[Array[Int]], index: Int) = {
    var sum = 0
    for (i <- 0 until a1.length) sum += a1(i) * a2(i)(index)
    sum
  }

  def apply(data: Array[Array[Int]]) = {
    new Matrix(data)
  }
}

object TestMatrix extends App {
  try {
    val m1 = Matrix(null)
    assert(false)
  } catch {
    case e: Exception => println("Expected error: " + e)
  }

  try {
    val m2 = Matrix(Array(Array(1, 2), Array(3)))
    assert(false)
  } catch {
    case e: Exception => println("Expected error: " + e)
  }

  private val m3 = Matrix(Array(Array(1, 2), Array(3, 4)))
  println(m3.dim)
  println()

  println(m3.toString)
  private val m4 = Matrix(Array(Array(1, 2), Array(3, 4)))
  println(m4.dim)
  println()

  println((m3 + m4).toString)

  println((m3 * 5).toString)

  println((m3 * m4).toString)

}

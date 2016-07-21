/*
3. Write a package random with functions nextInt(): Int, nextDouble(): Double
, and setSeed(seed: Int):  Unit.
To generate random numbers, use the linear congruential generator
next = (previous × a + b) mod 2n,
where a = 1664525, b = 1013904223, n = 32, and the inital value of previous is seed.
*/
package object random {
  val a = 1664525
  val b = 1013904223
  val n = 32

  Math.random()
  var previous: Int = 0
  var previousD: Double = 0.0

  def nextInt(): Int = {
    previous = (previous * a + b) % (math.pow(2, n).toInt)
    previous
  }

  def nextDouble(): Double = {
    previousD = (previous * a + b).toDouble % (math.pow(2, n))
    previousD
  }

  def setSeed(seed: Int): Unit = {
    this.previous = seed
    this.previousD = seed.toDouble
  }
}

object testrandom extends App {
  setSeed(System.currentTimeMillis().asInstanceOf[Int])
  println(nextInt())
  println(nextDouble())
  println(nextInt())
  println(nextDouble())
  println(nextInt())
  println(nextDouble())
}
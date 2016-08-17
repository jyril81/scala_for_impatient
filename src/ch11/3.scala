import scala.math.{abs, min}

/*
Implement the Fraction class with operations + - * /. Normalize fractions, for example turning
15/–6 into –5/2. Divide by the greatest common divisor, like this:

class Fraction(n: Int, d: Int) {
private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
override def toString = num + "/" + den
def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
...
}
 */


/**
  * Fraction in reduced form
  *
  * @param n
  * @param d
  */
class ReducedFraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

  override def toString = num + "/" + den

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def revert = {
    ReducedFraction(den, num)
  }

  /**
    * + operator
    *
    * @param summand
    * @return ReducedFraction which is sum of this object and summand
    */
  def +(summand: ReducedFraction) = {
    if (den == 0 || summand.den == 0) {
      ReducedFraction(1, 0)
    } else {
      val lcm = ReducedFraction.lcm(den, summand.den)
      val thisExtended = ReducelessFraction(num, den).multiply(abs(lcm / den))
      val otherExtended = ReducelessFraction(summand.num, summand.den).multiply(abs(lcm / summand.den))
      ReducedFraction(thisExtended.num + otherExtended.num, thisExtended.den)
    }
  }

  /**
    * - operator
    *
    * @param subtrahend
    * @return ReducedFraction which is difference of this object and subtrahend
    */
  def -(subtrahend: ReducedFraction) = {
    if (den == 0 || subtrahend.den == 0) {
      ReducedFraction(1, 0)
    } else {
      val lcm = ReducedFraction.lcm(den, subtrahend.den)
      val thisExtended = ReducelessFraction(num, den).multiply(abs(lcm / den))
      val otherExtended = ReducelessFraction(subtrahend.num, subtrahend.den).multiply(abs(lcm / subtrahend.den))
      ReducedFraction(thisExtended.num - otherExtended.num, thisExtended.den)
    }
  }

  /**
    * * operator
    *
    * @param factor
    * @return ReducedFraction which is product of this object and factor
    */
  def *(factor: ReducedFraction) = {
    if (den == 0 || factor.den == 0) {
      ReducedFraction(1, 0)
    } else {
      ReducedFraction(this.num * factor.num, this.den * factor.den)
    }
  }

  /**
    * / operator
    *
    * @param divisor
    * @return ReducedFraction which is qutient of this object and factor
    */
  def /(divisor: ReducedFraction) = {
    this * divisor.revert
  }
}

object ReducedFraction {
  def apply(n: Int, d: Int) = {
    new ReducedFraction(n, d)
  }

  /**
    * Calculate least common multiple
    *
    * @param a
    * @param b
    * @return
    */
  def lcm(a: Int, b: Int): Int = {
    def recLcm(a: Int, b: Int, lcm: Int): Int = {
      if (lcm % a == 0 && lcm % b == 0) lcm
      else recLcm(a, b, lcm + smallerAbs(a, b))
    }
    recLcm(a, b, smallerAbs(a, b))
  }

  /**
    * Find smaller abs value of args
    *
    * @param a
    * @param b
    * @return
    */
  def smallerAbs(a: Int, b: Int) = {
    min(abs(a), abs(b))
  }
}

/**
  * Fraction which is not automatically reduced
  *
  * @param num
  * @param den
  */
class ReducelessFraction(val num: Int, val den: Int) {

  def multiply(multiplier: Int) = {
    new ReducelessFraction(num * multiplier, den * multiplier)
  }
}

object ReducelessFraction {
  def apply(n: Int, d: Int) = {
    new ReducelessFraction(n, d)
  }
}


object TestFraction extends App {
  private val f1 = ReducedFraction(1, 2)
  private val f2 = ReducedFraction(1, 4)
  private val f3 = ReducedFraction(5, 0)
  private val f4 = ReducedFraction(-2, 7)
  println(f1)
  println(f2)
  println(f3)
  println(f4)
  println(ReducedFraction.lcm(1, 2))
  println(ReducedFraction.lcm(2, 3))
  println(ReducedFraction.lcm(2, 4))
  println(ReducedFraction.lcm(3, 7))
  println("Testing addition")
  println(f1 + "+" + f2 + "=" + (f1 + f2))
  println(f1 + "+" + f3 + "=" + (f1 + f3))
  println(f1 + "+" + f4 + "=" + (f1 + f4))
  println("Testing substraction")
  println(f1 + "-" + f2 + "=" + (f1 - f2))
  println(f1 + "-" + f3 + "=" + (f1 - f3))
  println(f1 + "-" + f4 + "=" + (f1 - f4))
  println("Testing multiplication")
  println(f1 + "*" + f2 + "=" + (f1 * f2))
  println(f1 + "*" + f3 + "=" + (f1 * f3))
  println(f1 + "*" + f4 + "=" + (f1 * f4))
  println("Testing division")
  println(f1 + "/" + f2 + "=" + (f1 / f2))
  println(f1 + "/" + f3 + "=" + (f1 / f3))
  println(f1 + "/" + f4 + "=" + (f1 / f4))
}

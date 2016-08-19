/*
4. Implement a class Money with fields for dollars and cents. Supply +, - operators as well as
comparison operators == and <. For example, Money(1, 75) + Money(0, 50) == Money(2, 25) should be
true. Should you also supply * and / operators? Why or why not?
 */

//Multiplying and division does not make sense for Money objects
//It only makes sense to multiply by some number or divide by some number, but not as an operator of Money

class Money(d: Int, c: Int) {

  if (d < 0 || c < 0) throw new IllegalArgumentException("Cannot have negative amount of money")

  //reduce to standard form on construction of the object
  private val dollars = d + c / 100
  private val cents = if (c >= 100) c % 100 else c

  def +(summand: Money) = {
    Money(this.dollars + summand.dollars, this.cents + summand.cents)
  }

  def -(subtrahend: Money) = {
    if (this < subtrahend) {
      throw new IllegalArgumentException("Cannot subtract  more than have");
    }
    val centsDifference = cents - subtrahend.cents
    val computedDollars = if (centsDifference < 0) dollars - subtrahend.dollars - 1 else dollars - subtrahend.dollars
    val computedCents = if (centsDifference < 0) math.abs(centsDifference) else centsDifference
    Money(computedDollars, computedCents)
  }

  def ==(other: Money) = {
    dollars == other.dollars && cents == other.cents
  }

  def <(other: Money) = {
    if (dollars < other.dollars) true
    else if (dollars == other.dollars) cents < other.cents
    else false
  }

  override def toString = {
    "Money(" + dollars + ", " + cents + ")"
  }
}

object Money {
  def apply(dollars: Int, cents: Int) = {
    new Money(dollars, cents)
  }
}


object TestMoney extends App {
  println("Testing creation")
  println(Money(1, 5))
  println(Money(1, 50))
  println(Money(1, 100))
  println(Money(1, 125))
  println("Testing addition")
  assert(Money(2, 30) + Money(1, 80) == Money(4, 10))
  assert(Money(1, 75) + Money(0, 50) == Money(2, 25))
  println("Testing substraction")
  try {
    println(Money(2, 30) - Money(2, 35))
  } catch {
    case e: Exception => println(e)
  }
  assert(Money(2, 30) - Money(2, 30) == Money(0, 0))
  assert(Money(2, 30) - Money(1, 80) == Money(0, 50))
  assert(Money(2, 30) - Money(1, 20) == Money(1, 10))
  println("Testing equality")
  assert(Money(2, 30) == Money(2, 30))
  assert(!(Money(2, 30) == Money(1, 30)))
  assert(Money(2, 30) == Money(1, 130))
  println("Testing lesstThan")
  assert(!(Money(2, 30) < Money(1, 20)))
  assert(Money(2, 30) < Money(3, 20))
  assert(Money(2, 30) < Money(3, 10))
}



/*
7. Implement a class BitSequence that stores a sequence of 64 bits packed in a Long value. Supply
apply and update operators to get and set an individual bit.
 */

class BitSequence(initialValue: Long) {
  val NR_BITS: Int = 64
  //needs to be var because update operator is changing bits
  var value: Long = initialValue

  def apply(index: Int): Boolean = {
    if (index < 0 || index >= NR_BITS) throw new IllegalArgumentException("Illegal bit index for long value")
    (value & (1L << index)) != 0
  }

  def update(index: Int, set: Boolean): Unit = {
    if (index < 0 || index >= NR_BITS) throw new IllegalArgumentException("Illegal bit index for long value")
    if (set) value = (value | (1L << index)) else value = value & (~(1L << index))
  }

  override def toString = {
    val asBinary: String = value.toBinaryString
    val nrNullsToPrepend = NR_BITS - asBinary.length
    "0" * nrNullsToPrepend + asBinary
  }

  def printDetailed = {
    for (i <- 0 until NR_BITS) println(i + "th bit =" + apply(i))
  }
}

object BitSequence {
  def apply(value: Long) = {
    new BitSequence(value)
  }
}

object TestBitSequence extends App {
  private val value: BitSequence = BitSequence(0)
  value.printDetailed

  value(0) = true
  value.printDetailed

  value(3) = true
  value.printDetailed
}
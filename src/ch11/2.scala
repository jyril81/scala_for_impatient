/*
2. The BigInt class has a pow method, not an operator. Why didn’t the Scala library designers
choose ** (as in Fortran) or ^ (as in Pascal) for a power operator?
 */
//Both identifiers are valid identifiers in scala. Meaning they are valid as bpth operayor (method) names
//or variable/class names. Following code demonstrated this:
class ** {
  def ** = {

  }

  def ^ = {

  }
}

object testidentifiers extends App {

  val ** = new **
}

//So scala library designers had othe reasons to avoid them
//^ was not used because Java already has ^ operator for bitwise XOR that can be applied to integer types
//scala is often used together with java and tries to have some logical synchronization with java, so
//it did not make sense to have same operator do different thing in scala

//** operator would have same precedence as */%
//this would bean that "2*3**2" is same as "(2*3)**2", which is not how it work in pure math.
//in math 2*3pow2 is 2*(3pow2)


//pow method was used as it is in Java BigInt to make usage of this class more familiar to users.
/*
CHAPTER 2
*/

/*
1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero.
Write a function that computes this value.
*/
def signum(number: Int) = {
  if (number > 0) {
    1
  } else if (number < 0) {
    -1
  } else {
    0
  }
}

signum(-3)
signum(0)
signum(5)


/*
2. What is the value of an empty block expression {}?
What is its type?
*/
// Thevalue is() and type is Unit.
// To check:
val a = {}


/*
3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
 (Hint: Pick a suitable type for x.)
*/
//In scala assignments have no value, or their value type is Unit.
//This means type of x must be Unit. Unit has only one value - ().
//In scala all variables and values must be initialized, unless they are class members.
//Thus we get
var x: Unit = ()
var y: Int = 2
x = y = 1

//The value of last expression is value of x which is ()
//Note that both variabls need to be defined as var-s, otherwise assignments wont work.


/*
4. Write a Scala equivalent for the Java loop
  for (int i = 10; i >= 0; i--) System.out.println(i);
*/
//Solution 1
for (i <- 0 to 10) println(10 - i)
//Solution 2
for (i <- (0 to 10).reverse) println(i)
//Solution 3, probably the most straightforward
for (i <- 10 to 0 by -1) println(i)


/*
5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
*/
def countdown(n: Int) = for (i <- n to 0 by -1) println(i)

countdown(10)


/*
6. Write a for loop for computing the product of the Unicode codes of all letters in
a string. For example, the product of the characters in "Hello" is 9415087488L.
*/
def uniSum(str: String) = {
  var acc = BigInt(1)
  for (ch <- str) acc *= ch.toInt
  acc
}

uniSum("Hello")


/*
7-8. Solve the preceding exercise without writing a loop.
(Hint: Look at the StringOps Scaladoc.)
*/
//Solution 1
def productAggregate(str: String) = {
  str.aggregate(BigInt(1))((product: BigInt, ch) => product * ch.toInt, (ch1, ch2) => ch1 * ch2)
}
productAggregate("Hello")

//Solution 2
def productFoldLeft(str: String) = {
  str.foldLeft(BigInt(1))((product, ch) => product * ch.toInt)
}
productFoldLeft("Hello")

//Solution 3
def productForeach(str: String) = {
  var product: BigInt = 1
  str.foreach(ch => product *= ch.toInt)
  product
}
productForeach("Hello")


/*
9. Make the function of the preceding exercise a recursive function.
*/
def productRecursive(str: String): BigInt = {
  if (str.length == 0) {
    1
  } else {
    str.charAt(0).toInt * productRecursive(str.takeRight(str.length - 1))
  }
}

productRecursive("Hello")


/*
10. Write a function that computes x^n, where n is an integer. Use the following recursive definition:
• x^n = y^2 if n is even and positive, where y = x^n / 2.
• x^n = x*x^n – 1 if n is odd and positive.
• x^0 = 1.
• x^n = 1 / x^–n if n is negative.
  Don’t use a return statement.
*/

//Solution 1 using ef-else blocks as values
def pow1(x: Int, n: Int): BigDecimal = {
  //var result = BigDecimal(0);

  if (n == 0) {
    1;
  } else if (n > 0) {
    if (n % 2 == 0) {
      pow1(x, n / 2) * pow1(x, n / 2)
    } else {
      x * pow1(x, n - 1)
    }
  } else {
    //n < 0
    1 / pow1(x, -n)
  }
  //result;
}

pow1(2, -3)
pow1(2, 0)
pow1(2, 3)

//Solution 2 using separate return variable
def pow2(x: Int, n: Int): BigDecimal = {
  var result = BigDecimal(0);

  if (n == 0) {
    result = 1;
  } else if (n > 0) {
    if (n % 2 == 0) {
      result = pow2(x, n / 2) * pow2(x, n / 2)
    } else {
      result = x * pow2(x, n - 1)
    }
  } else {
    //n < 0
    result = 1 / pow2(x, -n)
  }
  result;
}

pow2(2, -3)
pow2(2, 0)
pow2(2, 3)



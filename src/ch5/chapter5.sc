import scala.beans.BeanProperty

/*
1. Improve the Counter class in Section 5.1,
 “Simple Classes and Parameterless Methods,” on page
49 so that it doesn’t turn negative at Int.MaxValue.
 */
class Counter {
  private var value = 0

  def increment() {
    if (value < Int.MaxValue) {
      value += 1
    }
  }

  def current() = value
}


/*
2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
 */
class BankAccount(private var balance: Int) {

  def deposit(amount: Int) = {
    balance += amount
  }

  def withdraw(amount: Int) = {
    if (balance >= amount) {
      balance -= amount
    }
  }
}

val account: BankAccount = new BankAccount(100)

//does not compile
//account.balance = 5

/*
3. Write a class Time with read-only properties hours and
 minutes and a method before(other: Time):Boolean
 that checks whether this time comes before the other.
 A Time object should be constructed
as new Time(hrs, min), where hrs is in military
time format (between 0 and 23).
 */
class Time(val hour: Int, val min: Int) {
  def before(other: Time) = {
    if (hour < other.hour) {
      true
    } else if (hour == other.hour) {
      min < other.min
    } else {
      false
    }
  }
}

val t1: Time = new Time(10, 25)
val t2: Time = new Time(14, 5)
val t3: Time = new Time(14, 23)
assert(t1.before(t2))
assert(t2.before(t3))
assert(!t3.before(t1))


/*
4. Reimplement the Time class from the preceding exercise
 so that the internal representation is the
number of minutes since midnight (between 0 and 24 × 60 – 1).
 Do not change the public
interface. That is, client code should be unaffected by your change.
 */
class Time2(val hour: Int, val min: Int) {
  private val minSinceMidnight = hour * 60 + min

  def before(other: Time2) = {
    minSinceMidnight < other.minSinceMidnight
  }
}

val t21: Time2 = new Time2(10, 25)
val t22: Time2 = new Time2(14, 5)
val t23: Time2 = new Time2(14, 23)
assert(t21.before(t22))
assert(t22.before(t23))
assert(!t23.before(t21))


/*
5. Make a class Student with read-write JavaBeans properties name (of type String)
and id (of type Long). What methods are generated? (Use javap to check.)
 Can you call the JavaBeans getters and
setters in Scala Should you?
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

}

val jyril: Student = new Student("jyril", 66)
jyril.setName("newname")


/*
6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
on page 49, provide a primary constructor that turns negative ages to 0.
 */
class Person(var age: Int) {
  if (age < 0) age = 0
}

val p1: Person = new Person(5)
println(p1.age)
val p2: Person = new Person(-45)
println(p2.age)


/*
7. Write a class Person with a primary constructor that accepts
a string containing a first name, a space, and a last name, such as new Person("Fred Smith").
 Supply read-only properties firstName and lastName. Should the primary constructor
 parameter be a var, a val, or a plain parameter? Why?
 */
class Person3(fullName: String) {
  private val split: Array[String] = fullName.split(" ")
  val firstName: String = split(0)
  val lastName: String = split(1)
}

val p3: Person3 = new Person3("John Doe")
println(p3.firstName)
println(p3.lastName)

//primary ctor param should be without val/var  because we use it only as ctor parameter
//and don't want it as a field


/*
8. Make a class Car with read-only properties for manufacturer, model name,
and model year, and a read-write property for the license plate.
Supply four constructors. All require the manufacturer and model name.
 Optionally, model year and license plate can also be specified in
the constructor. If not, the model year is set to -1 and the license plate
 to the empty string. Which constructor are you choosing as the primary constructor? Why?
 */
class Car(val manufacturer: String,
          val model: String,
          val year: Int = -1,
          var licensePlate: String = "") {

  def this(manufacturer: String, model: String) = {
    this(manufacturer, model)
  }

  def this(manufacturer: String, model: String, year: Int) = {
    this(manufacturer, model, year)
  }

  def this(manufacturer: String, model: String, licensePlate: String) = {
    this(manufacturer, model, -1, licensePlate)
  }
}

//Main constructor takes all params
//main reason for this is to be able to have read-only properties as val-s with default values.
//I could also define year as var and then define year and licenseplate inside class as fields.
//But above approach seems better (less code and i get to use val and i can alsod rop all auxiliary ctors i i want to)

//analogous java class is approx 27 lines without writing getters/setters
//with getter/setters


/*
10. Consider the class
Click here to view code image
class Employee(val name: String, var salary: Double) {
def this() { this("John Q. Public", 0.0) }
}
Rewrite it to use explicit fields and a default primary constructor. Which form do you
prefer? Why?
 */
class Employee {
  var salary: Double = 0.0
  var name: String = "John Q. Public"

  def this(name: String, salary: Double) = {
    this()
    this.name = name;
    this.salary = salary
  }
}

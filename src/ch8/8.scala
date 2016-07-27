/*
8. Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,” on page 89 and
analyze the class files with javap. How many name fields are there? How many name getter methods
are there? What do they get? (Hint: Use the -c and -private options.)
 */
class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  // Don't want to reveal name . . .
  override val name = "secret"
  // . . . or class name
  override val toString = "secret"
}

//Java sources of both classes have private final name field and public getters for them.
//Person class getName returns name field in Person class
//SecretAgent class getName returns name filed in SecretAgentClass
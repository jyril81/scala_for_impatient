/*
9. Write a program that imports the java.lang.System class, reads the user name from the user.name
system property, reads a password from the Console object, and prints a message to the standard
error stream if the password is not "secret". Otherwise, print a greeting to the standard output
stream. Do not use any other imports, and do not use any qualified names (with dots).
 */

object inputTest extends App {

  private val username: String = System.getProperty("user.name")
  println(username)
  private val password = System.console().readLine()
  if (password == "secret") {
    System.out.println("Hello, " + username)
  } else {
    System.err.println("Wrong password")
  }
}

//In windows use cmd.cm to test this, git bash does not work!
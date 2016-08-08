/*
4. Provide a CryptoLogger trait that encrypts the log messages with the Caesar cipher. The key should
be 3 by default, but it should be overridable by the user. Provide usage examples with the
default key and a key of –3.
 */

trait CryptoLogger {
  val key = 3

  def log(msg: String) = {
    for (i <- 0 until msg.length) {
      print((msg.codePointAt(i) + key).asInstanceOf[Char])
    }
    println()
  }

}

class MyLogger(override val key: Int) extends CryptoLogger

object CryptoLoggerTest extends App {
  private val logger1: CryptoLogger = new Object with CryptoLogger
  logger1.log("Hello World!")
  private val logger: MyLogger = new MyLogger(-3)
  logger.log("Hello World!")
}
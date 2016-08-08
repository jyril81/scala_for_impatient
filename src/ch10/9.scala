import java.io.{FileInputStream, InputStream}

/*
9. Using the logger traits from this chapter, add logging to the solution of the preceding problem
that demonstrates buffering.
 */
trait Logged {
  def log(msg: String) {}
}

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}

trait ShortLogger extends Logged {
  val maxLength = 30

  // See Section 10.8 on fields in traits
  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) +
        "...")
  }
}


trait MyBufferedInputStream extends InputStream with ConsoleLogger with TimestampLogger with ShortLogger {
  private val BUFFER_SIZE = 10
  private val buffer = new Array[Byte](BUFFER_SIZE)

  //pos to be read next
  private var pos = -1


  override def read(): Int = {
    if (pos < 0) {
      //buffer is empty or consumed
      val readCount: Int = read(buffer, 0, BUFFER_SIZE)
      log("Read " + readCount + " bytes to  buffer")
      if (readCount < 0) {
        log("Stream exhausted")
        readCount
      } else {
        pos = readCount - 1
        val c = buffer(pos)
        log("Reading from buffer pos " + pos)
        pos -= 1
        c
      }
    } else {
      //read from buf
      val c = buffer(pos)
      log("Reading from buffer pos " + pos)
      pos -= 1
      c
    }
  }
}

//usage:
//scala TestStreamsLogged testdata.txt
object TestStreamsLogged extends App {
  private val stream = new FileInputStream(args(0)) with MyBufferedInputStream
  var c = stream.read()
  while (c >= 0) {
    c = stream.read()
  }
}
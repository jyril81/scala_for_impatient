import java.io.{FileInputStream, InputStream}

/*
8. In the java.io library, you add buffering to an input stream with a BufferedInputStream decorator.
Reimplement buffering as a trait. For simplicity, override the read method.
 */

trait MyBufferedInputStream extends InputStream {
  private val BUFFER_SIZE = 10
  private val buffer = new Array[Byte](BUFFER_SIZE)

  //pos to be read next
  private var pos = -1


  override def read(): Int = {
    if (pos < 0) {
      //buffer is empty or consumed
      val readCount: Int = read(buffer, 0, BUFFER_SIZE)
      if (readCount < 0) {
        readCount
      } else {
        pos = readCount - 1
        val c = buffer(pos)
        pos -= 1
        c
      }
    } else {
      //read from buf
      val c = buffer(pos)
      pos -= 1
      c
    }
  }
}

//usage:
//scala TestStreams testdata.txt
object TestStreams extends App {
  private val stream = new FileInputStream(args(0)) with MyBufferedInputStream
  var c = stream.read()
  while (c >= 0) {
    println("Read: " + c)
    c = stream.read()
  }
}
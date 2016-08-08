import java.io.{FileInputStream, InputStream}

/*
10. Implement a class IterableInputStream that extends java.io.InputStream with the trait Iterable[Byte].
 */

//Seems the ide is that clients are interested to get an iterable API over the stream

class IterableInputStream(val in: InputStream) extends InputStream with Iterable[Byte] {


  override def read(): Int = {
    in.read()
  }

  override def iterator: Iterator[Byte] = {
    new Iterator[Byte] {
      private var c: Int = IterableInputStream.this.read()

      override def hasNext: Boolean = {
        return c >= 0
      }

      override def next(): Byte = {
        val old = c
        c = IterableInputStream.this.read()
        old.asInstanceOf[Byte]
      }
    }
  }
}

object TestIterableStream extends App {
  private val stream: IterableInputStream = new IterableInputStream(new FileInputStream("testdata.txt"))
  stream.foreach(println(_))
}
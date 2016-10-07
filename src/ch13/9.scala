/*
9. Harry Hacker writes a program that accepts a sequence of file names on the command line. For
each, he starts a new thread that reads the file and updates a letter frequency map, declared as

val frequencies = new scala.collection.mutable.HashMap[Char, Int] with
scala.collection.mutable.SynchronizedMap[Char, Int]

When reading a letter c, he calls

frequencies(c) = frequencies.getOrElse(c, 0) + 1

Why won’t this work? Will it work if he used instead

import scala.collection.JavaConversions.asScalaConcurrentMap
val frequencies: scala.collection.mutable.ConcurrentMap[Char, Int] =
new java.util.concurrent.ConcurrentHashMap[Char, Int]
 */


/*
  First approach will not work correctly because

  frequencies(c) = frequencies.getOrElse(c, 0) + 1

  consists of 3 operations:
  1. getOrElse (which is synchronized)
  2. adding 1 to the result of previous step (local op)
  3. assigning new value to frequencis(c) (synchronized)

  All 3 ops together are not synchronized, thus different threads executing this block of code on shared frequencis map
  are suspectible to race conditions and that migh lead to incorrect resuls because of lost updates.


  Second approach suffers the same issue - compunds operations together are not synchronized. It does not mater matter
  well synchronized the target collection is.
 */

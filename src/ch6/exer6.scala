
/*
6. Write an enumeration describing the four playing card suits so that
 the toString method returns ♣, ♦, ♥, or ♠.
 */
object Suits extends Enumeration {
  val Clubs = Value("♣")
  val Diamonds = Value("♦")
  val Hearts = Value("♥")
  val Spades = Value("♠")
}

object Test extends App {
  println(Suits.Clubs)
  println(Suits.Diamonds)
  println(Suits.Hearts)
  println(Suits.Spades)
}

//UTF-8 output does not work with Idea workseets. Use scala compiler and runtime.
//To get corect output run the program as follows:
//scala -Dfile.encoding=UTF-8 Test

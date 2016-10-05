/*
6. Given a list of integers lst, what is (lst :\ List[Int]())(_ :: _)? (List[Int]() /: lst)(_ :+ _)? How
can you modify one of them to reverse the list?
 */
object ListTest extends App {
  val lst = List(1, 2, 3)

  println(lst)
  //(lst :\ List[Int]())(_ :: _)
  //it does foldRight with initial element being an empty list and binary op being list prepend
  //result is a new list identical to given lst
  println((lst :\ List[Int]()) (_ :: _))

  //(List[Int]() /: lst)(_ :+ _)
  //it does foldLeft with initial element an empty list and binary op list append
  //result is a new list identical to given lst
  println((List[Int]() /: lst) (_ :+ _))

  //to produce reversed list just use foldright with append or foldleft with prepend
  //since operators are oparnd order sensitive, i need to use explicit variables
  println((lst :\ List[Int]()) ((x, y) => y :+ x))
  println((List[Int]() /: lst) ((x, y) => y :: x))
}

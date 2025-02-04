package part4_Pattern_Matching

object PatternsEverywhere extends App {

  //big idea #1
  try {
    //code
  }
  catch {
    case e : RuntimeException=> " runtime"
    case npe : NullPointerException=> "npe"
    case _ => " something else "
  }

  // catches are the MATCHES
  /*
   try {
    //code
  }
  catch (e){ e match {
    case e : RuntimeException=> " runtime"
    case npe : NullPointerException=> "npe"
    case _ => " something else "
  }} //make it in pattern matching
   */

  // big idea #2
  val list= List(1,2,3,4)
  val evenOnes = for {
    x<- list if x % 2 ==0 // ?!

  } yield 10*x //make it in pattern matching
// generators are also based on pattern matching
 val tuples = List((1,2),(3,4))
  val filterTuples = for {
  (first,second) <-tuples
} yield first*second   // make it in pattern matching
// case classes ,:: operators ,...


// big idea #3
 val tuple = (1,2,3)
 val (a,b,c)= tuple
 println(b) // output:2
 // multiple valuue defination based on pattern matching

 val head :: tail = list
 println(head) // output : 1
 println(tail)  // output : List(2, 3, 4) // there is lot of pattern matching going on in between all these
 /// try all again with pattern  matching to enhance the concept

 // big idea #4
 // partial function based on pattern matching
  val mappedList = list.map {
    case v if v % 2 ==0 => v + " is even "
    case 1=> " the one "
    case _ => " something else "

  }// partial function literal
  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 => v + " is even "
    case 1 => " the one "
    case _ => " something else "

    }
  }// both above two are same
  println(mappedList) // output is : List( the one , 2 is even ,  something else , 4 is even )
  println(mappedList2) // output is : List( the one , 2 is even ,  something else , 4 is even )


  // try all again with pattern matching to get a hold of pattern matching 
}

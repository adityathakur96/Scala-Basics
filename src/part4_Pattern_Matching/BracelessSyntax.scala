package part4_Pattern_Matching


// whatever you chose weather conventional style or brace less style you should stick throughout the project with it only do not mismatch with each other it will make things mess
object BracelessSyntax {

  // if- expressions
  val onIfExpressions1 = if (2 > 3) "bigger" else "smaller"

  // java style
  val onIfExpressions2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

  // compact
  val onIfExpressions3 =
    if (2 > 3) "bigger"
    else "smaller"
  //scala 3 here the then for it using without round bracket we have to use then for it u have to properly indent it like python
  // scala 3 syntax
  val onIfExpressions4 =
    if 2 > 3 then
      "bigger" // higher indentation than the if part
    else
      "smaller"

  val onIfExpressions5 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result
  // the below 4 expressions are the scala exclusive
  // scala 3 one-liner
  val onIfExpressions6 = if 2 > 3 then "bigger" else "smaller"

  // for comprehensions
  val aForComprehensions = for {
    n<- List (1,2,3)
    s<- List("black","yeild")
  } yield s"$n and $s"


  // scala 3 style for for comprehensions
  val aForComprehensions2 =
    for
      n<- List (1,2,3)
      s<- List("black","yeild") // for without ncurly braces you have to be super careful for indentation
    yield s"$n and $s"





  // structure like pattern matching in scala 3
  val meaningOfLife = 42
  val aPatternMatch = meaningOfLife match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  // scala 3
  val aPatternMatch_v2 =
    meaningOfLife match
      case 1 => "the one"
      case 2 => "double or nothing"
      case _ => "something else"



  // methods without braces
  def computeMeaningOfLife(arg:Int):Int =
    val partialresult = 40


  // whenever it is in same indentation it is inside the code only and it will not give error


    partialresult +2



  // classes , traits , objects , data types and enums with significant indentation as well

 // class definition with this
 class animal{
   def eat():Unit =
     println("i am eating")
 }

  class animal1: // here the colon give the idea about the significant indentation to the compiler that we are starting
    // it and the indentation region will be selected for it here that is below
    def eat(): Unit =
      println("i am eating")
    end eat
    def grow():Unit=
      println("i am growing")  // its still in above class as it is indented still
       // if you have 300 lines of code and we don't know where the class ends or new code start then we use end token like below so that we get to know that that the above class ended here
  end animal1  // you can use this end token for , like for comprehensions , if , pattern matching , methods , classes , enums , traits and pretty much everything that has certain indentation
  //  use end token for legit more than 4 to 5  lines of code so that we can read at ease

  // anonymous classes
//  val aSpecialAnimal = new animal1 {
//    override def eat():Unit = println("iam eating ")
//  }
  val aSpecialAnimal = new animal1:  //for removing the bracket in here to we have to use colon so that  compiler get to know that u have starting indenting it
    override def eat(): Unit = println("iam eating ")

  end aSpecialAnimal

  // indentation = strictly larger indentation
  // either indent with spaces or tabs don't mix them otherwise compiler will get confuse at some point
  // 3 spaces + 2 tabs > 2 spaces + 2 tabs
  // 3 spaces + 2 tabs > 3 spaces + 1 tab
  // 3 tabs + 2 spaces ??? 2 tabs + 3 spaces

  // this style is somewhat more of a related with python and can increase learning python 











  def main(args: Array[String]): Unit = {
    // Correctly reference the variables inside the main method
    println(onIfExpressions1)
    println(onIfExpressions2)
    println(onIfExpressions3)
    println(onIfExpressions4)
    println(onIfExpressions5)
    println(onIfExpressions6)
    println(computeMeaningOfLife(54))  // output is : 42
  }

}

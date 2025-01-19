package part3_FunctionalPrograming

import scala.util._


object HandlingFailure extends App{

  //create success and failure explicitly
  val aSuccess= Success(3)  //Success(3): Creates an instance of Success, a subclass of Try, representing a computation that was successful, storing the value 3.
  val aFailure = Failure(new RuntimeException(" SUPER FAILURE")) //Failure(new RuntimeException(" SUPER FAILURE")): Creates an instance of Failure, representing a computation that failed, storing an exception.

  println(aSuccess)
  println(aFailure)
  def unsafeMethod():String= throw new RuntimeException("no string for you buster ")


  //Try objects via the apply methods
  val potentialFailure = Try(unsafeMethod()) // Try do not crash program as it convert crashing into Failure
  println(potentialFailure)

// syntax sugar
val anotherpotentialfailure = Try{
  // code that might throw
}

//utilities
println(potentialFailure.isSuccess)// output : false

//orElse
//if someone  give you unsafe apis

def backupMethod():String = "a valid result "

val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
println(fallbackTry) //Success(a valid result )

// if you design a api
def betterunsafemethod (): Try[String] = Failure(new RuntimeException())
def betterbackupmethod(): Try[String] = Success("a valid result ")

val betterFallBack = betterunsafemethod() orElse betterbackupmethod()

// whenever u have hunch your code will give you null use options  and if you think code will throw exceptions use Try

// it also has map , flatMap , filter
println(aSuccess.map(_*2)) // output is   : Success(6)
println(aSuccess.flatMap(x=>Success(x*10)))  // output : Success(30) // firsly _ giving error so passed correct lambda here
println(aSuccess.filter(_ > 10)) // this success will turn into failure  // output : Failure(java.util.NoSuchElementException: Predicate does not hold for 3)

// => for comprehensions

/*
exercise
 */

val host = " localhost"
val port = "8080"
  def renderHTML(page:String) = println(page)

 class Connection {
  def get(url:String):String = {
    val random = new Random(System.nanoTime())
    if (random.nextBoolean()) "<HTML>...</HTML>"
    else throw new RuntimeException("connection interrupted")
  }
  def getSafe(url:String):Try[String] = Try(get(url))
}

object HttpService {
  val random = new Random(System.nanoTime())

  def getConnection(host:String,port:String):Connection=
    if (random.nextBoolean()) new Connection
    else throw new RuntimeException("someone else took the port ")
    //getConnection returns a Connection, not a Try[Connection].




  def getSafeConnection(host:String,port:String):Try[Connection] = Try(getConnection(host,port))
}
  //if you get the html page try to print from the connection, print it to the console i.e. cal renderHTML
  val possibleConnection= HttpService.getSafeConnection(host,port)
  /*
  flatMap Method: This method is part of the Scala collections and monadic types (Option, Try, Future, etc.).
  It allows for chaining operations that produce monads, enabling you to flatten the result.
  For example, Option[A] can use flatMap to return another Option[B], ultimately giving you an Option[B].
  Regular Classes and Objects: Standard classes and objects (like your Connection class) don't naturally support flatMap because they are not monads.
  Monads have specific structures that include operations like map, flatMap, filter, etc., which regular classes don't implement unless explicitly defined.
   */
  // i have below written flatMap givng error as above writting getConnections instead of getSafeConnection
  val possibleHTML = possibleConnection.flatMap(connection=>connection.getSafe("/home")) //When you call flatMap on possibleConnection, flatMap expects possibleConnection to be of type Try[Connection].
  possibleHTML.foreach(renderHTML) // it will print page  , but all do depend on random and .nextBoolean to satisfies the need of above function to provide required answer
// If possibleConnection is a Success, flatMap fetches the HTML safely. If it's a Failure, the operation short-circuits, and no further operations are performed.
//Since getConnection throws an exception directly if it fails, it would cause the program to crash immediately 
  // if the exception is thrown, and the Try mechanism wouldn't be in place to handle it safely.
  // short hand version of this

    HttpService.getSafeConnection(host,port)
      .flatMap(connection=>connection.getSafe("/home"))
      .foreach(renderHTML)

  // for comprehension
  for {
    connection<- HttpService.getSafeConnection(host,port)
    html<-connection.getSafe("/home")
  } renderHTML(html)



  // code in imperative language
  /*
  // nested try's  but if i had 10 nested try here it will not readable so above method are more suitable
    try {
      connection = HttpService.getConnection(host, port)
      try {
        page = connection.get("/home")
        renderHTML(page)
      } catch (some other exception) {

      }
    } catch (exception) {

    }

   */

}

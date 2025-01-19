package part2oops



//import org.graalvm.compiler.nodes.InvokeWithExceptionNode
import scala.util.control

object Exceptions extends App{

  val x:String = null


 //  println(x.length)
 // this will crash with null pointer exception

  // throwing and catching exception
  //val aWiredvalue :String = throw new NullPointerException   // in scala throwing an exception is an expression
  // exception are instances of classes thats why new  here
  
   // throwable classes extend the the throwable class
   // exception and error are the major throwable subtypes   exceptions and error have their own sementics

   // 1.  how to catch exceptions
    def getint(withException:Boolean ) :Int =
      if (withException) throw new RuntimeException("no Int for You ")
      else 42


//    try {
//      // code that might throw
//      getint(true)
//    }
//    catch {
//     // case e:RuntimeException=> println("caught a runtime exception ")
//      case e: NullPointerException => println("caught a runtime exception ")
//    }
//    finally {   // finally is also key word in scala
//      // code that will get executed no matter what
//      println("finally")
//    }
  val potentialFail = try {
    // code that might throw
   // getint(false)
    getint(true)
  }
  catch {
    case e: RuntimeException => 43
     //case e:RuntimeException=> println("caught a runtime exception ")
    //case e: NullPointerException => println("caught a runtime exception ")
  }
  finally { // finally is also key word in scala
    // code that will get executed no matter what
    println("finally")     // finally block  is optional as it will print no matter what and it doesnot influence the return type of this expression
    // use finally for only of side effects
  }

    println(potentialFail) // print 43 i have to make println as try in  val

    //3. HOW TO  define your own exception
    class MyExecption extends  Exception  {  // Exception  is a inbuilt class in scala
    val exception = new MyExecption


    throw exception
  }


  /*
  1. crash your program with an out of memorary error
  2. crash with stack overflow error
  3 pocket calculator
  - add(x,y)
  - subtract
  - multiply
  - divide

  throw
    - overflowexception if add(x,y) or multiply  exceeds the int_max value
    - underflowExeption if (subtraction ) exceeds the int_min value
    - mathcalculationerror if divide with 0
   */
 // val array =Array.ofDim(Int.MaxValue)    // this is also called oom// this is how you crash the system with error called out of memory error

//   def infinite :Int=1 + infinite
//   val Nolimit = infinite       // this is stack overflow error

class overflowException extends RuntimeException
class unerflowException extends RuntimeException
class mathCalculationException extends RuntimeException("division by 0")
object pocketCalculator {
  def add(x:Int,y:Int) = {
    val result = x + y
    if(x>0 &&y>0 && result<0)  throw new overflowException
    else if (x<0 && y<0 && result >0) throw new unerflowException
    else result
  }

  def substract(x:Int,y:Int) = {
    val result = x-y
    if(x>0 &&y<0 && result<0)  throw new overflowException
    else if (x < 0 && y > 0 && result > 0) throw new unerflowException
    else result
  }
  def multiply(x:Int,y:Int) = {
    val result = x*y
    if (x > 0 && y < 0 && result < 0) throw new overflowException
    else if (x < 0 && y < 0 && result < 0) throw new overflowException
    else if (x > 0 && y < 0 && result > 0) throw new unerflowException
    else if (x < 0 && y > 0 && result > 0) throw new unerflowException
    else result

  }
  def divide(x:Int,y:Int) ={
    val result= x/y
    if (y==0) throw new mathCalculationException
    else result

  }

}
//
  // println(pocketCalculator.add(Int.MaxValue,10))  // it will give negative value as int limit exceed so using if and else
println(pocketCalculator.divide(2,0))
}

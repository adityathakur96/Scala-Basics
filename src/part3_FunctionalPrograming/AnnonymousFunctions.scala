package part3_FunctionalPrograming

object AnnonymousFunctions extends App {
//  val doubler = new Function1[Int , Int]{
//    // override def apply(x:Int):Int=x*2
//  }   there is syntactic sugar for all this crap that is below

val doubler=(x:Int) =>x*2 // anonymous function or lambda expression
// lambda is the instance of Function1

// also we can define above as below
val doubler1:Int=>Int=x =>x*2  // compiler will itself think that x is int and return type of x is int

// multiple parameter in lambda
val adder:(Int,Int)=>Int=(a:Int,b:Int) =>a+b

  //  if no parameter
  val justdosomething:()=>3 =()=>3
  println(justdosomething) //function itself // part3_FunctionalPrograming.AnnonymousFunctions$$$Lambda$17/0x00000001000b9440@74ad1f1f
  println(justdosomething()) // lambda should be call with parenthesis //function call


  // curly braces with lambda

  val stringToInt = {(str:String)=>
    str.toInt

  }

  //more syntactic sugar
  val niceIncrementer :Int=>Int = (x:Int)=>x+1 // shorter way to write this below
  val niceIncrementer1 :Int=>Int = _+1 //equivalent to x=>x+1
  val niceadder:(Int,Int)=>Int= _+_//  equivalent to(a,b) =>a+b // _ is constrental that means we have give the parameter type
  println(niceadder(3,3))

  val superAdd= (x:Int)=>(y:Int)=>x+y   // this is the lambda version of curried function
  println(superAdd(3)(4))
  /*

 1. mylist : replace all functionX ith lambda's
  2. define or rewrite the special adder the curried one as anonymous function
   */


}

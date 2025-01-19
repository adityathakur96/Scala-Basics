package part3_FunctionalPrograming

object Whatafunction extends App{

//use and work with functions as first class elements
// problem :we came from oop world

val doubler = new MyFunction[Int,Int] {

  override def apply (element:Int):Int= element*2
}

println(doubler(2))  // doubler is like instance of of class like trait and we can call it like a function in here

 // function types = function1[A,B]
 // scala support these parameter up to 22 parameter
 val stringtointconverter = new Function1[String,Int] {   // Function came from scala predef
   override def apply (string:String):Int= string.toInt
 }

  println(stringtointconverter("3")+4)

  val adder= new Function2[Int,Int,Int]{    // val adder:Function2[Int,Int,Int]= new Function2[Int,Int,Int] its
    // syntactic sugar is val adder:((Int,Int)=>Int)
    override def apply(a:Int,b:Int):Int=a+b
  }
  // function types Function[A,B,R] === ((A,B)=>R) means the result is r of a and b

  // ALL SCALA FUNCTIONS ARE OBJECTS


  /*
 1. define a function which takes two string and concatenate them
  2. go to mylist and transform the mypredicate and mytransformer into function types
  3. define a function which takes an Int and returns another function which takes int and return as int
     - define whats the type of the function
     - how to do it this special function
   */



  val concatenate = new  Function3[String,String,String,String] { // here the no. defines that how much of parameter it can take , in scala no. go to upto 22
    override def apply(a:String,space:String,b:String) :String= a+space+b
  }    // other method can be of this

  def concatenation :(String,String)=>String= new Function2[String,String,String]{
    override def apply(a:String,b:String) :String= a+b
  }
  println(concatenate("hello"," ","scala"))

// 3 is also higher order function
// Function1[Int,Function1[Int,Int]]

val supperAdder : Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]]{
  override def apply(x:Int):Function1[Int,Int]= new Function1[Int,Int]{
    override def apply (y:Int):Int=x+y
  }
}
val adder3= supperAdder(3)
println(adder3(4))
println(supperAdder(3))
println(supperAdder(3)(4)) //curried function they can have no. of function inside them 


}

trait MyFunction[A, B] {
  def apply(element: A): B 

}

package part1basics

object valuesvariabletypes extends App{
  val x = 42 // val x:Int =42  compiler can infer the type
  println(x)
// val is vlaues
 // x=2 // vals are immutable

  val aString : String =" hello " ;
  val anotherString =" goodbyes "
  val aBoolean :Boolean =false
  val aChar : Char ='a'
  val aInt :Int =x
  val aShort:Short=4653  // half of int i.e 2 bytes
  val aLong : Long = 34023578203L
  val aFloats : Float =2.0f
  val aDouble: Double= 3.14
  
  
  //variables
  var aVariables: Int=4
  aVariables=5 // side effects vars are mutables 
  
  
  
  
}

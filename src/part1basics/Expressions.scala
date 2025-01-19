package part1basics
// in scala always stick with values
object Expressions  extends App{

// values are with val which are immutable
  val x=1+2  // expressions
  println (x)
  print(2+3*2)
  //  mathematical expression  +,-,*,/,&,|,<<,>>,    (right shift with zero extension) >>>

  println(1==x)
  // ==,!=, > , >=, <, <=

  println(!(1==x))
  // ! , ||, &&
// variable  with var which are mutable

  var aVariable =2
  aVariable +=3
  // also works with -= += /= .... side effects
  println(aVariable)
  // instructions (do)  vs expressions (VALUE)

  // IF expressions
  val aCondition = true
  val aCondtionedValue = if(aCondition) 5 else 3   // means when if statement get true aCondtionedValue get value 5 otherwise 3
  println(aCondtionedValue)
  println(if(aCondition) 5 else 3)
  println(1+3)
  var i =0
  while (i<10){
    println(i)
    i+=1
  }
  // NEVER USE LOOPS AGAIN IN SCALA as loops used in imperative programming as in c, c++, java, python
  // everything in scala is an expressions

   val aWierdValue = (aVariable=3)  // unit ==void  it dont return anything meaningfull aVariable causing side effect in printin
   println(aWierdValue)
   
   // side effects : println()  , whiles, reassinging 
   //code blocks 
   val aCodeBlock ={
     val y=2
     val z=y+1
     if ( z>2) " hello " else " goodbye"
    }                                               // codeblocks are expressions 
   
   //  val aAnothervalue =z-1 error as z is not outside 
   
   
   // 1. diffrence bw " hello world " and println("hello world")  first one is string type other is side effects as it is unit one  
   
   val somevalue={
     2<3            // it is boolean 
   }
val someanothervalue={
  
  if(somevalue) 239 else 434
  42
}   // value of  someanothervalue is 42 here if statement is irrelevent














}

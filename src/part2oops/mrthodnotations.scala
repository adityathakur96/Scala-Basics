package part2oops

import scala.language.postfixOps

object mrthodnotations extends App{
  class Person(val  name :String,favoriteMovie:String ,val age: Int=0 ){
    def likes (movie:String ): Boolean =movie==favoriteMovie
    def /*hangOutWith*/+(person:Person): String =s"${this.name} is hanging out with ${person.name}" // this name represent first name pf person object
    // but the person .name represent the parameter in new person class given in below
    def +(nickname:String):Person = new Person(s"$name($nickname)", favoriteMovie )
    def unary_! : String  = s"$name , what the heck ?" // space is important bw the unary operator and :
    def unary_+ :Person = new Person(name, favoriteMovie ,age+1)
    def isALive : Boolean =true
    def apply():String = s" hi my name is $name and i like $favoriteMovie and iam turning $age"
     def apply(n:Int) :String = s" $name wathced $favoriteMovie  $n times "


    def learns(thing:String ) :String = s"$name is learning $thing"
    def learnsScala =this  learns "scala"// = this learns ("scala") = learns("scala") but not equal to learns "scala"
    // this means the current instance of leans here
  }

  val marry =new Person("marry","inception",13)
  println(marry.likes("inception")) // (object.method(parameter)) => important
  println( marry likes "inception") // equivalent to above //called INFIX notation = operator notation (example of syntactic sugar )
  // this works only when method has one parameter

  val tom =new Person("tom ","fight club")
  println(marry + tom)  //hangOutWith got replaced with + we can these type of thing in scala
  println(marry.+(tom))
  println(1+2)
  println(1.+(2))   // all operators are methods(are methods or can be made just like above ) as well as operations
  println(!marry)
  println(marry.unary_!) // they both are same above ans this one


// PREFIX notation it is all about unary operators (they are also methods ) below // syntatactic notation

  val x= -1  // equivalent with 1.unary_-
  // here sometimes spacing matters that while writting val x=-1 giving error i think it is making it becasue
  // compiler thinking that - is operator name  thatswhy space is important
  val y= 1.unary_-
  //unary_prefix only works with -, + , ~, !


 // POSTFIX notation (example of syntactic notation as using space instead of dot operator but only works when method has only one or no parameter

println(marry.isALive)
println (marry isALive)


// special method name      apply
println(marry.apply())
println(marry()) // this what happens when use apply method as function define in class
// whenever the compiler see the object itself calling with parenthesis it seearch for apply method in class

/*
1. overload the + operator
 marry +the rockstar =>new person "marry (the rockstar) overloading of infix operator
 2. add an age to the person class
add a unary +operator => new person with the age +1
+marry => marry with the age incrementer

3. add a " learns method in the person class => " marry learns scala "
add aa learn scala method , calls learn method with "scala "
use it in the postfic notation
4.  overload the apply method
marry.apply(2) => "marry watched the favroute movie 2 times "
 */

println(marry.+("the rockstar")()) // both are same this line and below line
println((marry + "the rockstar"  )())  // INFIX NOTATION  // also the code is working like val marryRockstar = marry + "the rockstar"
// then calling the apply function println(marryRockstar())  and the other thing happend that new Person instance where the name is modified to include the nickname in parentheses.
 println((+marry)()) // this statement is correct but we cannot excess age here alone so we get error thats why we need val to age so to make is field so that we can access it

println((+marry).age) // PREFIX NOTATION  // it giving error as no val included inside the person class for age // now val is given there now printing age of marry
// VAL ki jarurat upper isliye paddi ass usse class ke bahr use karna tha
//POST FIX  notation=>
println(marry.learnsScala) // only available for methods with no parameters
println(marry learnsScala)  // its the same as above 
println(marry(2))
}

package part4_Pattern_Matching
import scala.util._
object patternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {     // match is keyword
    case 1 => " the one "            // case pattern arrow result every pattern written in this form
    case 2 => "double or nothing "
    case 3 => "third time is the charm "
    case _ =>  " something else " // _ = WILDCARD  or u can say default// also for _ space is important
  }
// here above is pattern matching here the value is trying to match with multiple patterns and each pattern written with the case statement
// that is case pattern arrow result every pattern written in this form  it looks like switch statement in cpp but pattern matching is more powerful
  println(x)
  println(description)


  //1. decomposes the values
  case class Person(name :String,age:Int)
  val bob= Person("Bob",20)

  val greeting = bob match {
    case Person (n,a) if a<21=> s"hi my name is $n and i can't drink in the us " // here if is guard statement
    case Person (n,a)=> s"hi my name is $n and iam $a years old "
    // it can extract name and age and return  the string with name and age
    // even though the matching doesnt know this in the first place
    case _ => " i don't know who i am "
  }
  println(greeting)

/*
1. cases are matched in order
2. what if no cases matched ? we will get scala.MatchError
3. whats the type of pattern match expression ? the unified type of all types in all cases give the lowest common ancestors if no match like String and Int it will give "any"
4. pattern matching really well with case classes as here with sealed it will give error only to resolve this we will se that in advance course
 */

// pattern matching on sealed hierarchies
sealed class Animal
  case class Dog(breed:String) extends Animal
  case class Parrot (greeting:String) extends Animal

  val animal:Animal = new Dog("terra nova")
  animal match { //match may not be exhaustive.  It would fail on pattern case: _: Animal as class Animal is sealed class
    case Dog(someBreed) => println( s"matched a dog of the $someBreed breed")
  }

  // match everything
  val isEven = x match {
    case n if n%2==0 => true
    case _ => false  // why!! this

  }

  val isEvenCond = if(x%2==0) true else false // why!! also this
  val isEvenNormal = x%2==0//  this also give the perfect result


  /*
      Exercise
      simple function uses PM
       takes an Expr => human readable form

       Sum(Number(2), Number(3)) => 2 + 3
       Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
       Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
       Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
     */
  trait Expr
  case class number(n:Int) extends Expr
  case class sum(e1: Expr , e2: Expr )extends Expr
  case class prod (e1: Expr , e2: Expr )extends Expr

  def show(e:Expr):String= e match {  // here e is the expression that defines number , sum and prod
    case number(n)=> s"$n"
    case sum (e1,e2)=> show(e1)+" + " + show(e2)  // here show method is recursively calling
    case prod(e1,e2)=>{
      def maybeShowParenthesis(exp:Expr)= exp match {//now here again exp is expression type that now defines the prod,number and default
        // and give result with which it matches
        case prod(_,_)=>show(exp) // now calling recursively here like above
        case number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParenthesis(e1)+ " * "+ maybeShowParenthesis(e2)
    }

  }

  println(show(sum(number(2),number(3))))
  println(show(sum(sum(number(2), number(3)), number(4))))
  println(show(prod(sum(number(2), number(1)), sum(number(3),number(4)))))
  println(show(sum(prod(number(2), number(1)), number(3))))




  


}

package part4_Pattern_Matching

import part2oops._

object AllThePatterns extends App{

//  //1 - constants
//  val x: Any = "scala"
//  val constants = x match {
//    case 1 => " a numbers"  // a literal or constant can be anything int , string,plain value , Boolean , singleton object
//    case "scala" => "THE SCALA "
//    case true => "THE TRUTH "
//    case AllThePatterns => " a singleton object"
//    case _ => " hello you are a clown "
//  }
//  println(constants)
//  //2 - match anything
//  //2.1 WILDCARD
//  val matchAnything = x match{
//    case _ =>
//  }
//  println(matchAnything) // output of it is ()
//  //2.2 variables
//  val matchAVariable = x match {
//    case something => s"I've found $something"
//  }
//  println(matchAVariable)
//
//
//  // 3 - tuples
//  val aTuple=(1,2)
//  val matchATuple = aTuple match {
//    case(1,1) =>
//    case (something,2)=>s" i have found $something"   // if after the something part matches it give the result
//   // A named variable, like something, binds the value it matches to the variable name.
//   // You can then use this variable in the expression on the right-hand side of the match.
//
//  }
//
//  println(matchATuple)
//
//  // 3.1 nested Tuple
//  val nestedTuple = (1,(2,3))
//  val matchNestedTuple = nestedTuple match {
//    case (_,(2,v)) =>           //The underscore (_) matches the first element of the tuple (1,(2,3)),
//    // which is 1, but you don't need to use it later, so you discard it with _.
//    // here underscore is wildcard
//  }
//
//  /*
//  Key Differences:
//Wildcard (_): Matches anything but does not capture or bind the value.
//Named Variable (something): Matches anything and captures the value to be used later.
//   */
//  // PMs can be nested as here nested Tuple
//  // PMs can be nested with case classes as well
//
//  // 4- case classes  - this is called the constructor pattern
//  val aList :myList[Int] = cons(1,cons(2,Empty))
//  val matchAList = aList match {
//    case Empty =>
//    case cons(head,cons(subhead,subtail))  =>               // case classes can also be nested
//  }
//
//
//  // 5 - list pattern =  a powerful use case
//
//  val aStandardList =List(1,2,3,42)
//  val standardListMatch = aStandardList match {
//    case List(1,_,_,_) => //this type of extractor exist in scala class - more of it going to learn in advanced
//    case List(1,_*) =>  // list of arbitrary length - advanced
//    case 1 :: List (_)=> //infix pattern
//    case List(1,2,3) :+ 42 => // also a infix pattern
//  }
//
//  // 6 - type specifier
//  val unknown :Any = 2
//  val unknownMatch = unknown match {
//    case list :List[Int] => // explicit type specifier
//    case _=>
//
//
//  }
//
//  // 7 - name binding
//
//  val nameBindingMatch = aList match {
//    case nonEmptyList @ cons(_,_) => // name binding => which makes u use the name later(here)
//    case cons(1,rest @ cons(2,_)) => // nam binding inside the nested pattern here u can use the rest later in return object
//
//  }
//
//
//  // 8 - multi - pattern
//  val multiPattern = aList match {
//    case Empty | cons(0,_) => // | this a pipe operator u can chain as many as thing with it // compound pattern (multi-pattern)
//  }
//
//
//  // 9 - if guards
//  val secondElementspecial = aList match {
//    case cons(_,cons(specialElement, _)) if specialElement % 2 ==0 =>
//  }


  // that's all
  /*
  question.
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings :List[String] => " a list of strings "
    /*
    Capitalization: Scala conventionally uses lowercase for variable names.
     If you use a name starting with an uppercase letter,
      Scala might interpret it as a type or object, leading to an error.
    Here, ListOfStrings might be interpreted as a type or object, not a variable name. The correct usage would be:
     */
    case listOfNumbers : List[Int] =>"a list of numbers "
    case _ => " something else "
  }
  println(numbersMatch) // it is coming a list of strings but it is not scala or compiler fault as it should be list of numbers
  // jvm trick question 
  /*
  jvm with java 9 can run java 1 program but java 1  didn't have generic type it came in java 5 so below is explanation what happen for it and so scala 
  also work on jvm so it also effect it that's why compiler saying something about listOfStrings
  
  Java 5 Generics: Generics were introduced in Java 5, 
  but they were implemented using type erasure. 
  This means that all generic type information is erased during compilation, and at runtime, generic types are treated as their raw types.

Type Erasure: Because of type erasure, you cannot use runtime type information to differentiate between List[String] and List[Int]. 
They are both treated as List in the JVM. This affects pattern matching and type checking in Scala when dealing with generics.
   */

}



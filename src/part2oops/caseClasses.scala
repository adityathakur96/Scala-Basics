package part2oops

object caseClasses extends App{
/*
equals , hash code ,toString
 */

 case class Person(name:String,age:Int)
//1. class parameter are fields

val jim = new Person("jim",34)
 println(jim.name) // with case , class parameter are fields if not case then val name should be written

// 2. sensible toString
// println(instance) = println(instance.toString) // syntactic sugar
 println(jim.toString) // ans of it Person(jim,34)
 // if case to be removed then ans of jim.toString is part2oops.caseClasses$Person@262b2c86
 
 //3. equals and hash code implemented out of the box 
 val jim2=  new Person("jim",34)
 println(jim==jim2) // it is true if not written case then it false as in default setting the compiler thinks that 
  // they are the 2 different instance of class as it a default reference value and it is generally false then it comes false 
  
  // 4. case classes have handy copy method (duplicates)
   val jim3=jim.copy(age=45) // it create the new instance of this case class also copy method can get named parameter 
  println(jim3) // give  Person("jim",45) 
  
  // 5. case classes have companion objects 
  val thePerson= Person   // as i have used case here then compiler will automatically make the companion object for this class therefore then here Person is companion object 
  val marry= Person("marry",23) // we can call this companion object as apply method for the class 
  // makes it like calling a function so that we can instantiate the instance of class without keyword new 
  // it  its the super property of companion objects in case classes they(apply method ) do the same thing as a constructor 
  
  // 6. case classes are serializable 
  // useful in akka framework 
   // 7. case classes have extractor patterns = case classes can be used in pattern matching 
   
   // 8. case object it works as case class but it a object 
    case object UK {
     def name : String = " they are people from uk "
   }  // they have all properties of objects but not have companion object as they are their own companion objects 
  
  
  /*
   expand myList - use case classes and case objects 
  with this i made my myList too strong and with lot of new features 
   */
  
  




}

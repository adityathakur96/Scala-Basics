package part3_FunctionalPrograming
// Tuples are immutable
object TuplesAndMaps extends App
{
  //tuples =finite ordered Lists
  //val aTuple = new Tuple2(2,"hello, Scala")  // Tuple2(Int,String) = (Int,String)  this is a syntactic sugar for tuple2
 // val aTuple =  Tuple2(2, "hello, Scala") // it is correct as well as TUPLE has correct apply method in their companion objects
  val aTuple = (2, "hello, Scala")  // as mentioned above that it is syntactic sugar for Tuple2

  // Tuple can come up with 22 element of different types as simply it can go up to Tuple22 , why 22  as they are used in conjuction function types as FunctionX also goes to 22

  println(aTuple._2) // output is at no. 2 that is : hello, scala
// ._ it is the method to retrieve given no. element in  tuple these are called Positional methods and they are unique to tuples in scala

  println(aTuple.copy(_2= "goodbye java")) // we can use copy method just as we have done in case classes
  println(aTuple.swap) // output : (hello, Scala,2)


  // maps : are collections use to associate things with other things  - keys-> values means i.e Map(key,value)
  val aMap: Map[String,Int] = Map() // empty map

  val phoneBook = Map(("Jim", 555), "Danial"->1979 ).withDefaultValue(-1) // here compiler will itself think that what is the type of Map it is
  // map with tuples and we have syntactic sugar "danial"->1979  ("danial",1979)
  // a->b syntactic sugar for(a,b)

  println(phoneBook) // output here : Map(jim -> 555, danial -> 1979)

  // Map operations

  println(phoneBook.contains("Jim")) // output true as key jim exits in phoneBook
  println(phoneBook("Jim")) // output of it : 555  key giving the value inside the map
 //  println(phoneBook.apply("jim"))  = println(phoneBook("jim"))

  println(phoneBook("marry")) // it crashes the programs with NoSuchElementException can be remove by withDefaultValue()
  // then if apply method call with another  key it will return inside value in this case -1 an invalid no.
  // inside withDefaultValue() we can put string or a number to



  // add a pairing
   val newpairing = "marry"-> 445
  val newPhonebook = phoneBook + newpairing

  println(newPhonebook)


  // functions on Maps
  // map , flatMap,filter

  println(phoneBook.map(pair=> pair._1.toLowerCase->pair._2)) // argument inside the map is pairing which is a tuple, so does flatMap , filter
  // here all the keys goes to lowercase


  // filter keys
  //println(phoneBook.view.filterKeys(_.startsWith("J")).toMap)  // actually _ is shorthand notation for lambda  x=>x
  println(phoneBook.view.filterKeys(x=>x.startsWith("J")).toMap) // output :Map(Jim -> 555) it will give only paring that pass this predicate of capital j ans that is Jim then it will map it then give output

  // mapValues
  println(phoneBook.view.mapValues(number=>number*10).toMap) // output :Map(Jim -> 5550, Danial -> 19790)
  println(phoneBook.view.mapValues(number => "0245-" + number).toMap) // Map(Jim -> 0245-555, Danial -> 0245-1979)

  //coversions
  println(phoneBook.toList) //List((Jim,555), (Danial,1979))
  println(List(("danial",555)).toMap) //Map(danial -> 555)
  val names = List("bob","james","angella","mary","danial","jim")
  println(names.groupBy(name=> name.charAt(0))) // HashMap(j -> List(james, jim), a -> List(angella), m -> List(mary), b -> List(bob), d -> List(danial))
  // whoever get same character at zero they will groupBy  together




  /*
     1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

         !!! careful with mapping keys.

     2.  Overly simplified social network based on maps
         Person = String
         - add a person to the network
         - remove
         - friend (mutual)
         - unfriend

         - number of friends of a person
         - person with most friends
         - how many people have NO friends
         - if there is a social connection between two people (direct or not)
    */

  // if put "JIM" -> 900 over a phoneBook it will go smoothly but on the time of lowercase the "Jim" and "JIM" overlap and give the result like Map(jim -> 900, danial -> 1979) so always be careful for having keys with same names in mapping keys 


// answer of 2 in exercise package 
  
 }
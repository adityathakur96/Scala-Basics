package part3_FunctionalPrograming
// Scala collections use the apply method for element access. Seq, List, and Array.
import scala.util.Random

object Sequences extends App{

  // Seq
  val aSequence = Seq(1,3,2,4)  // this is apply method from Seq companion  object
  println(aSequence)  // Seq is a list  // Seq is inbuilt for sequences and it is like a list as this companion object has apply factory method by which we can make subclasses with list
  println(aSequence.reverse)
  println(aSequence(2)) //a apply method with 2 means aSequence.toGet method at index 2 and give no. at index 2 // also aSequence(2) =aSequence.apply(2)
  println(aSequence ++ Seq(5,6,7))  // ++ is again a inbuilt operator from (scala. collection. IterableOps) for concatenation and in previous sections we are leaning that how are they created to learn more but here we can get these by inbuilt or calling libraries or  collections
  println(aSequence.sorted)


  // ranges which also are sequences
  // ranges are magical data structures
  val Arange: Seq[Int]= 1 to 10 // type parameter making the val safe with integer
   Arange.foreach(println) // output no. from 1 to  10 each in different lines
   println(Arange) // its output : Range 1 to 10
   // Type Inference: When you specify val Arange: Seq[Int] = 1 to 10, Scala infers that Arange is of type Seq[Int], but the actual object assigned is a Range.
  println(Arange.toList) //output : List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(Arange.mkString(",")) // output:  1, 2, 3, 4, 5, 6, 7, 8, 9, 10



  val arange: Seq[Int]= 1 until 10 // its like to but the right side is exclusive
  arange.foreach(println)

  (1 to 10 ).foreach(x=>println("hello"))

  //Lists

  val aList = List(1,2,3)

  val prepended= 42 :: aList // here :: is a operator and :: is syntactic sugar  for ::.apply(42) and list with it  method here
 // +:  do the same like here does by :: also a syntactic sugar
  println(prepended)

  // for appending
  val appended = prepended :+ 43  // :+ doing appending here also syntactic sugar
  println(appended)

// to append at particular index we have to create a method for it no inbuilt method for it
  def insertAtIndex[T](list: List[T], index: Int, element: T): List[T] = {
    val (front, back) = list.splitAt(index)
    front ::: element :: back
  }

  // ':::' : This operator is used to concatenate two lists
  // '::' : This operator is used to prepend an element to a list
  // means ++ and ::: do the same thing concatenation
  //splitAt: This method splits the list into two parts at the given index.
  // The first part includes all elements up to, but not including,
  // the index. The second part includes the rest of the elements starting from the index.

  // Example usage:
  val rList = List(1, 2, 3)
  val withElementInserted = insertAtIndex(rList, 1, 42)
  println(withElementInserted) // Output: List(1, 42, 2, 3)


  /*
  You can combine both methods to handle both prepend and append scenarios by checking
   if the position is at the beginning or end of the list:

  def insertOrAppendAtIndex[T](list: List[T], index: Int, element: T, append: Boolean = false): List[T] = {
  if (append) {
    appendAtIndex(list, index, element)
  } else {
    insertAtIndex(list, index, element)
  }
}

// Example usage:
val aList = List(1, 2, 3)
val inserted = insertOrAppendAtIndex(aList, 1, 42)  // Prepend at index 1
val appended = insertOrAppendAtIndex(aList, 1, 43, append = true)  // Append after index 1

println(inserted)  // Output: List(1, 42, 2, 3)
println(appended)  // Output: List(1, 2, 43, 3)

 */

  val apples5 = List.fill(5)("apples") // fill is a curried function that takes a value ,
  // a number and make a list with 5 times or  n time of that value
  println(apples5) // output : List(apples, apples, apples, apples, apples)
  println(aList.mkString("-|-")) // make list with the separator whatever inside output is : 1-|-2-|-3

   // arrays       THEY ARE DIRECT IMPLEMENTATION ON JAVA'S NATIVE ARRAY'S

//   val numbers = Array(1,2,3,4)
//   val threeElements = Array.ofDim[Int](3)
//
//    println(threeElements)// output :[I@5204062d
//  println(threeElements.foreach) //output : part3_FunctionalPrograming.Sequences$$$Lambda$20/0x00000001000db840@2fd66ad3
//  threeElements.foreach(println) // output is 3 zero in different lines


  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println) // output is  3 values showing null in different lines
  println(numbers) // output is [I@1cab0bfb it will only give the address of the array storage
  // for making it print we have to always use foreach or mkString
  println(numbers.mkString(", "))
  // for arrays println works different : Arrays in Scala do not override the toString method to provide a readable representation of their elements.
// Arrays: Do not have a custom toString method for readable output,
  // so you need to use mkString or similar methods to print their elements. but the seq and list do have
// mutation
 numbers(2)= 10 // syntax sugar for numbers.update(2,0) as also update  is rarely used as update is only work with mutable collections  , update is special method in scala and very close to apply method


  println(numbers.mkString(","))

  // relation between arrays and sequence
  val numberSeq :Seq[Int] = numbers  // implicit conversions

 println(numberSeq)  // Output: ArraySeq(1, 2, 10, 4)
  // but according to the vd it should be WrappedArray(1, 2, 10, 4)
  /*
  val numbers = Array(1, 2, 3, 4)
val wrappedArray: Seq[Int] = numbers.toSeq

println(wrappedArray)  // Output: WrappedArray(1, 2, 3, 4)
   */


  // vectors


  val vector :Vector[Int] = Vector(1,2,3)
  println(vector) // they do work like seq and lists

  val maxRuns = 1000
  val maxcapacity = 1000000
  // vectors vs list
   def getWriteTime(collection:Seq[Int]) :Double = {
     val r = new Random
     val times = for {

       it<- 1 to maxRuns
     } yield {
       val currenttime = System.nanoTime()
       collection.updated(r.nextInt(maxcapacity),r.nextInt())
       System.nanoTime() - currenttime
     }
     times.sum * 1.0/ maxRuns

// The random number generation is simple with new Random and nextInt().

   }

  val numbersList = (1 to maxcapacity).toList
  val numbersvector = (1 to maxcapacity).toVector

  println(getWriteTime(numbersList)) // advantage of list : keeps the reference to tail  disadvantage : updating a element in middle takes long time
  println(getWriteTime(numbersvector)) // advantage  of vector : depth of tree is small  , disadvantage : needs to replace an entire 32 - element chunk


val aStringlist = List("apples","apples")

println(aStringlist)
}

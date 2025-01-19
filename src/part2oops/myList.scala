package part2oops

abstract class myList[+A] {
  /*
  head return int first element of the list
  tail = remainder of the list
  isempty=boolean is this list empty
  add(int)=> new list with this element added
  tostring => a string representation of the list
   */
  def head :A
  def tail:myList[A]
  def isempty:Boolean
  def add[B >: A] (element:B) :myList[B]
  def printElements :String
  //polymorphic call
override def toString :String= "["+ printElements +  "]" // + operator is used for concatenation here,
  // +operator  just concatenating the brackets on both side
// toString function is present in ref class so we have to override it

// below 3 are called higher order functions  they either receive functions as parameter or give functions as result 
def map[B] (transformer: A=>B):myList[B]
def flatMap[B] (transformer: A=>myList[B]):myList[B]
def filter(predicate:A=>Boolean):myList[A]
//concatenation 
def ++[B>:A](list:myList[B]):myList[B]  // method for concatenation

//hofs
def foreach(f:A=>Unit):Unit
def sort(compare:(A,A)=>Int):myList[A]
def zipWith[B,C](list:myList[B],zip:(A,B)=>C):myList[C]
def fold[B](start:B) (operator:(B,A) =>B):B

  // New method for `withFilter`
  def withFilter(predicate: A => Boolean): myList[A] = filter(predicate)
}


//we need emptyList and non emptylist
case object Empty extends myList[Nothing] {   // objects can inherit the classes
  // nothing is a proper subtitute of anytype of typed parameter that i can come in everything
// in an empty list there is  no head and tail
  def head: Nothing= throw  new NoSuchElementException

  def tail: myList[Nothing]= throw  new NoSuchElementException

  def isempty: Boolean= true

  //def add[B >: Nothing] (element:Nothing) :myList[B] = new cons(element,Empty)
  def add[B >: Nothing](element: B): myList[B] = new cons(element, Empty) // hwy the hell iam doing it with element :nothing

   def printElements : String = " "

  def map[B](transformer: Nothing=> B): myList[B] = Empty

  def flatMap[B](transformer: Nothing=> myList[B]): myList[B] =Empty

  def filter(predicate: Nothing=>Boolean): myList[Nothing]=Empty

  def ++[B >: Nothing](list: myList[B]): myList[B] = list // method for concatenation

  // hofs
  def foreach(f:Nothing=>Unit):Unit= ()  // () it is the unit value

   def sort(compare: (Nothing, Nothing) => Int) = Empty

  def zipWith[B, C](list: myList[B], zip: (Nothing, B) => C): myList[C]=
    if (!list.isempty)  throw new RuntimeException("List do not have the same length")
    else Empty

  def fold[B](start:B)(operator:(B,Nothing)=>B): B = start
}

case class cons[+A](h:A , t : myList[A]) extends myList[A]      // linked list look like which has head and tail
 {
   def head: A = h

  def tail: myList[A] = t

  def isempty: Boolean = false

  def add[B >: A] (element:B) :myList[B] = new cons(element,this) // this refers to the current instance of cons class
  def printElements : String =
    {

      if(t.isempty) " " + h
      else s"$h  ${t.printElements}"                                            // h + s" " + t.printElements this is for scala 2 in here with scala 2 +operator doing concatenation
    }

  /*
  [1,2,3].filter(n%2==0)=
  [2,3].filter(n%2==0)=
  new cons(2,[3]filter(n%2==0))=
  new cons(2,empty.filter(n%2==0))
  =new cons(2,empty)
  =[2]
   */
  def filter(predicate: A=>Boolean): myList[A] =
    if (predicate(h)) new cons(h,t.filter(predicate))
    else t.filter(predicate)
/*
[1,2,3].map(n*2)
= new cons(2,[2,3].map(n*2))
= new cons(2,new cons (4,[3].map(n*2)))
=new cons (2,new cons (4,new cons(6,empty.map(n*2))))
=new cons (2,new cons (4,new cons(6,empty)))
 */
  def map[B](transformer: A=> B): myList[B]=
    new cons(transformer(h),t.map(transformer)) // recursive call

    /*
    [1,2] ++[3,4,5]
    = new cons (1,[2] ++[3,4,5]
    = new cons(1,new cons(2,empty ++[3,4,5]))
    = new cons(1,new cons(2 ,[3,4,5]))
    =new cons (1,new cons (2 , new cons(3, new cons(4, new cons(5, empty))))))
     */

   def ++[B >: A](list: myList[B]): myList[B] = new cons(h, t ++ list) // method for concatenation
   /*
    [1,2].flatmap(n=>[n,n+1]) =
    [1,2] ++ [2].flatmap(n=>[n,n+1])=
   [1,2] ++ [2,3] ++ Empty.flatmap(n=>[n,n+1])=
   [1,2] ++ [2,3] ++ Empty
   =[1,2,2,3]
   */
   def flatMap[B] (transformer: A=>myList[B]):myList[B] =
     transformer(h)  ++ t.flatMap(transformer)
// removing the tranformer her means we are calling method that is apply method

//  hofs
def foreach(f: A => Unit): Unit = {

  f(h)
  t.foreach(f)
}

def sort(compare:(A,A)=>Int):myList[A] = {
  //insertion sort
  def insert(x: A, sortedList: myList[A]) :myList[A] ={
    if (sortedList.isempty) new cons(x,Empty)
    else if (compare(x,sortedList.head)<=0) new cons(x,sortedList)
    else new cons(sortedList.head,insert(x,sortedList.tail))  // it is not tail recursive if we want can
  }
  val sortedtail= t.sort(compare)
  insert(h,sortedtail)


}
/*
TAIL RECURSIVE OF ABOVE
def sort(compare: (A, A) => Int): myList[A] = {

    @annotation.tailrec
    def insert(x: A, sortedList: myList[A], acc: myList[A] = Empty): myList[A] = {
      if (sortedList.isempty) reverse(cons(x, acc))
      else if (compare(x, sortedList.head) <= 0) reverse(cons(x, sortedList)).prepend(acc)
      else insert(x, sortedList.tail, cons(sortedList.head, acc))
    }

    @annotation.tailrec
    def reverse(list: myList[A], acc: myList[A] = Empty): myList[A] = list match {
      case Empty => acc
      case cons(h, t) => reverse(t, cons(h, acc))
    }

    @annotation.tailrec
    def sortAcc(unsorted: myList[A], sorted: myList[A]): myList[A] = unsorted match {
      case Empty => sorted
      case cons(h, t) => sortAcc(t, insert(h, sorted))
    }

    sortAcc(this, Empty)
  }

use of tail recursion
val myList: myList[Int] = cons(3, cons(1, cons(2, Empty)))

val sortedList: myList[Int] = myList.sort(_ - _) // Sorts in ascending order

// Result: sortedList = cons(1, cons(2, cons(3, Empty)))
 */
def zipWith[B, C](list: myList[B], zip: (A, B) => C): myList[C] =
  if (list.isempty) throw new RuntimeException("List do not have the same length")
  else new cons(zip(h, list.head), t.zipWith(list.tail, zip))

   
/*
[1,2,3].fold(+)=
=[2,3].fold(1)(+)=
=[3].fold(3)(+)=
= empty.fold(6)(+)= 
start value that is 6 now 
 */
def fold[B](start: B)(operator: (B, A) => B): B = {
 // val newstart= operator(start,h)
  //t.fold(newstart)(operator)
  t.fold(operator(start,h))(operator)
  
}
 }




//trait MyPredicate[-T] { // function type of T=>boolean
//  def test (element:T) :Boolean
//}
//
//trait MyTransformer[-A, B] { // function type of A=>B
//  def transform(element:A):B
//}











object ListTest extends App {
val ListOfInteger : myList[Int] = new cons(1,new cons(2,new cons (3, Empty)))
  val ListOfString : myList[String] = new cons("hello",new cons("scala",Empty))
  val anotherListOfInteger : myList[Int] = new cons(4,new cons(5, Empty))
  val cloneListOfInteger : myList[Int] = new cons(1,new cons(2,new cons (3, Empty)))

  println(ListOfInteger.printElements)
  println(ListOfString.printElements)

  println(ListOfInteger.toString)  // toString is inbuilt method in scala
  println(ListOfString.toString)
  // the difference bw the output of two that the ans is concatenate with [ square brackett
  // also we have override the string above

  //println(ListofInteger.map(element=>element*2 ).toString)
  println(ListOfInteger.map(_*2 ).toString)
  //println(ListofInteger.filter(element=>element % 2==0).toString)  //check above filter and also why it is not returning 2 here
  println(ListOfInteger.filter(_ % 2 == 0).toString)
  println(( ListOfInteger ++ anotherListOfInteger).toString)
  println(ListOfInteger.flatMap(element=>new cons(element, new cons (element+1,Empty))
  // lambda form cant be implement on it as element is coming two times and it will give error 
  ).toString)
  println(cloneListOfInteger==ListOfInteger) // it will return true as we have used case class above if not case than for getting true i have to work on lots of recursive calls

 // ListofInteger.foreach(x=>println(x)) the short hand notation below
  ListOfInteger.foreach(println)  // 1 2 3 on separate lines

  println(ListOfInteger.sort((x,y)=>y-x))     // it should be x-y so that result will be in ascending order but here y-x giving in descending order

  println(anotherListOfInteger.zipWith[String, String](ListOfString,_ +"-"+_)) //_ +" "+_ shorthand lambda notation with  concatenation
  // here error coming because _ +" "+_ is contractual as which _ is what  so we gonna pass parameter [String,String]
  
  // spark users and data scientist use zipping a lot 
  
  
  println(ListOfInteger.fold(0)(_+_)) //("Adding a number and a String is deprecated. Use the string interpolation `s\"$num$str\"`", "2.13.0
//  we call fold as reduce sometimes


// for comprehensions
// we have made the flatMap before like this here so that for comprehensions can work out here if i want to use for comprehensions like this i have to make the flatMap, map , filter like these what they are here 
val combinations = for {
  n<-ListOfInteger // the error coming because as we have made the flatmap on our own but it also has in scala pre def itself so the conflict arises
  // as i have named it before flatmap instead of flatMap so the error coming here is value flatMap is not a member of part2oops.myList[Int] -
  // did you mean ListofInteger.flatmap?   //  n<-ListofInteger

  string<-ListOfInteger
} yield n+"-"+string


println(combinations)  // for comprehensions are the expressions so it can come in println as well
println(for {
  n<-ListOfInteger
  string<-ListOfString
} yield n+"-"+string
)
}

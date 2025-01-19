package part2oops

object ooBasics extends App{
val person = new Person("john",20)
  println(person.age)
  println(person.x)// we can access body vals and vars of inside the class but then it will show all the answer like side effect println
   println(person.greet("aditya"))  // person.greet("aditya") even it give the dame result fot it
  person.greet()
  person.greet("aditya")
//println(person.age) error coming as class parameters are not fields as we connot do abouve person.age


val author =new Writer ("charles","dickens",1812)
val imposter=new Writer("charles","dickens",1812) //The isWrittenBy method checks if the given author parameter is the same as the author field of the book instance.
 // This check uses the default == operator, which for objects, checks reference equality (whether the two references point to the same object).
val novel =new novel ("great Expactations",1861,author )  // MOST IMPORT LINE IN THIS TO UNDERSTAND 
println(novel.authorAge)
println(novel.isWrittenBy(imposter)) // imposter matches with author but object name differ so compiler give false as
// novel written by author but not by imposter instead it should give the true meaning imposter in author but compiler saying imposter is imposter


val counter =new Counter
counter.inc.print
counter.inc.inc.inc.print
counter.inc(10).print

}

//constructor
class Person(name :String ,val age:Int=0){ // if we set default parameter then we dont have to use auxilary constructor
  //body // val, making it a public field of the class.
  val x=2
  println(1+3) // is console 4 apppears above as it is a side effect of using println as it is

  def greet(name: String): Unit = { println(s"${this.name} says : hi ,$name ")}
  //  this shows the name which is parameter of class and second name after hi shows that name is parameter of greet
  //def greet(othername:String):Unit= println(s"$name says : hi ,$othername ") it can be used





  //overloading
  def greet(): Unit = println(s"${this.name} says :hi ")
  // here this.name and name is similar because in both cases it will take parameter name of class
  // error will come in overloading if give like this  def greet(): Int = 42

  // multiple constructor  or overloading constructors
  def this(name: String) = this(name,0) // This auxiliary constructor takes a single name parameter and defaults age to 0 by calling the primary constructor.
 // Calls the primary constructor with default age 0
 def this()=this("john doe")
}
// class Person(name :String ,age:Int)  //constructor
//class parameters are not fields as we connot do abouve person.age
/*
novel and a writer
writer :first name ,surname
-method fullname
novel :name , year of release author
-author age
-isWrittenby(Author)
-copy(newyear of release )=new instance of novel
 */

class Writer(firstName:String,surname :String , val year:Int) { //year is declared as val, making it a public field of the class.
  def fullName:String=firstName +" " + surname

}
class novel(name:String ,year :Int ,author :Writer){
  def authorAge=year-author.year
  def isWrittenBy(author:Writer )=author==this.author
  def copy(newYear:Int):novel=new novel(name,newYear,author)
}



/*
val author =new Writer ("charles","dickens",1812)
val imposter=new Writer("charles","dickens",1812)
val novel =new novel ("great Expactations",1861,author )
println(novel.authorAge)
println(novel.isWrittenBy(imposter)) // imposter donot have author in it as val author

 */











/*
 counter class
-receives current count
-method of inc/dec to receive an amount
overload inc/dec to recieve an amount

 */
class Counter(val count:Int=0){
  def inc= {

    println("incrementing")
    new Counter (count+1) //// immutability check this
  }
  def dec ={
    println("decrementing")
    new Counter (count-1)
  }


  def inc(n:Int) :Counter ={
    if (n<=0) this  // provide the current instance 
    else inc.inc(n-1)


  }
  def dec(n: Int):Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }
  def print = println(count)
}
/*
val counter =new Counter
counter.inc.print
counter.inc.inc.inc.print
 */
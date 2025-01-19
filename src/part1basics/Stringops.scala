package part1basics

object Stringops extends App{


  val str:String ="hello, I am learning scala"
  println(str.charAt(2))
  println(str.substring(7,11)) // both no. are inclusive
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))// replace space with -
  println(str.toLowerCase())
  println(str.length)

  val aNumberString ="2"
  val aNumber=aNumberString.toInt
  println('a'+: aNumberString :+ 'z') // prepending and apending
  println(str.reverse)
  println(str.take(2))
//s-interpolators => below
  val name="david"
  val age=12
  val greeting = s"hello,my name is $name and iam $age years old "   // the name and the age will be injected with the help of $ sign but when s is written outside the string
  val anotherGreeting = s"hello,my name is $name and iam turning  ${age+1} years old " //  we can perform operation inside the string by using currly braces
  println(anotherGreeting)

  //F-interpolators => below
val speed =1.2f
  val myth=f"$name can eat $speed%2.2f burgers per minute "
  println(myth)

  //raw interpolator
  println(raw"This is a \n newline") // there is no effect of \n which give new line by using raw interpolator
  val escaped ="this is a \n newline"
  println(raw"$escaped") // injected variable do get escaped

}

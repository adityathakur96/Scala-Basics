package part3_FunctionalPrograming

object mapflatmapFilterFor extends App{


  val list = List(1,2,3)  //standard library for list we are calling apply method on list companion objects
  println(list)


  println(list.head)
  println(list.tail)  // for more search list on scala-lang.ord

  // map
  println(list.map(_+1))
  println(list.map(_+" is a number"))


  // filter
  println(list.filter(_%2==0))

  //flatmap
  val topair= (x:Int)=> List(x,x+1)

  println(list.flatMap(topair))


  // print out al combination between two list
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  // list("a1","a2",......,"d4")
  val colors = List("black","white")


  //val combinations= number.flatMap(n=>chars.map(c=>colors.map(co=>""+c+n+co))) // this is mistake i have made on first try but then i got the hang of it
  //iterations
  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-"+color)))

  println(combinations)


  //foreach
  list.foreach(println) // out pu of it will be 1 2 3 each in different line

 // println(list.foreach) //output of it : part3_FunctionalPrograming.mapflatmapFilterFor$$$Lambda$24/0x0000000100118040@4cf4d528


  // for-comprehensions

  val forcombination = for {
    n<-numbers if n%2==0 // it is a if guard in comprehension // here it will only take even no. as filter is applied as above filter would have to apply
    // like this numbers.filter(_%2==0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-"+color)))
    c<- chars
    color<- colors
  } yield "" + c + n + "-"+color  // exactly equivalent to above map, flatmap combination


  println(forcombination)

 for {
   n<-numbers  // side effect a it is same as above or equivalent as compiler do this

 } println(n)



 // syntax overload
 list.map{ x=>
   x*2

 }


 /*
  1.  MyList supports for comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2.  A small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter

  */
}

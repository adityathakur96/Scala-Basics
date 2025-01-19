package part1basics

object CBNvsCBV extends App{

  def calledByValue(x:Long) : Unit={
    print("by value" +x)
    print("by value" +x)
  }

  def calledByNume(x: => Long): Unit={
    print("by name" + x)
    print("by  name" + x)
  }

  calledByValue(System.nanoTime())
  println("        ")  // in callbyvalue the value itself used every time that is when the functionnn istell called the same value repeated as x is replaced with 129319405916500L
  // but when the callbyname fucntion called it replace x with System.nanoTime() and every time new value of system time generated
  calledByNume(System.nanoTime())
  println("   ")



  def infinite():Int= 1+infinite()
  def printFirst (x:Int,y: => Int)=println(x)   //this will print only first one not the byname one

  //printFirst(infinite(),34)
printFirst(34,infinite())



}

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
  println("        ")
  calledByNume(System.nanoTime())
  println("   ")



  def infinite():Int= 1+infinite()
  def printFirst (x:Int,y: => Int)=println(x)
printFirst(34,infinite())
}

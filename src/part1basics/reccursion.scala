package part1basics

import scala.annotation.tailrec

object reccursion extends App{
  def aFactorial(n: Int): Int =
    if (n <= 0) 1
    else {
      println("computing Factorial of "+ n + "- I first need factorial  of " +(n-1))
      val result = n * aFactorial(n - 1)
      println("computing factorial of "+n)

      result

    }

println(aFactorial(10))
   // println(aFactorial(5000))      /// it will give error of stackoverflow error


def Factorial(n:Int):BigInt = {
  @tailrec         // if you dont know that your fuction is tail recursive then you can add this and check if it show error
  //  if not tail recursive
  def factHelper(x:Int , accumulator:BigInt ) :BigInt=
  if (x<=1) accumulator
  else factHelper(x-1,x*accumulator)
  factHelper(n,1)
}
/*
factorial(10)=
facthelper (10,1)=
facthelper(9, 10*1)=
......=
factHelper(2,3*4*5*6*7*8*9*10*1) =
factHelper(1,1*2*3*4*5*6*7*8*9*10*1)=
1*2*3*4*5*6*7*8*9*10*1



 */
println(Factorial(5000))          // thhis prevent scala to use another stack frame as previous one store
   // in that stack frame only  due to using of facthelper  that is reccursive stack frame
   // it is called tail recursion and compiler can tell it is tail reccursion
   // tail reccursion = use the recurssive call as the last expression



 // when you need loops , use tail recursive

 /*
 1. concatenate a string n time
 2. is prime fucntion tail reccursive
 3. fibonacci  function tail recursice
 any function can become tail rrecursive by using as many accumulator asa you need 
  */
// the no. of accumulator depend on how many time recursion is called
@tailrec
 def concatenateTailRec(aString:String ,n:Int,accumulator:String):String =


   if (n <= 0) accumulator
   else concatenateTailRec(aString, n - 1, aString + accumulator)

println(concatenateTailRec("Hello",4,""))

def fiboonacci(n:Int ) :Int ={
   def fiboTailrec(i:Int,last:Int,nextToLast:Int):Int =
     if (i>=n) last
     else fiboTailrec(i+1,last+nextToLast,last)

  if(n<=2) 1
  else fiboTailrec(2,1,1)


}
println(fiboonacci(8))

}

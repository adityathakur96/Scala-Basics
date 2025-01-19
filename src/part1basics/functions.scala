package part1basics

object functions extends App{

  def aFunction(a: String ,b:Int):String  =                    // a is name and after that string is its type  and it will return string
  {
    a+ " " +b
  }        // concatination

  println(aFunction("hello",3))


  def aParenthesisLessFunction (): Int = 442
  println(aParenthesisLessFunction())
  // println(aParenthesisLessFunction) in scala 3 it is forbid to use parenthesis function without them


  def aRepeatedFunction(aString :String , n:Int ) :String ={             //reccursive function
    if(n==1) aString
    else aString +" " + aRepeatedFunction(aString,n-1)
  }
  println(aRepeatedFunction("hello",3))
  // when you need loops , use recursion
  // here also we can remove the return type of fucntion as compiler itself capable of thinking
  // what will be the return type but the reccuresive function needsd the return type and compiler complain about it
// but always give return type


def aFunctionWithSideAffect(aString : String ) : Unit =println(aString)
def aBigFunction(n:Int ):Int={
def aSmallFunction (a:Int,b:Int) :Int = a+b
  aSmallFunction(n,n-1)
}


/*
 1. a greeting function(name,age ) => hi , my name is $name and i am $age years old
2.  factorial function
3. fibonacci series f(n)=f(n-1)+f(n-2)
4. test if a no. is prime of not

 */


//1.
def aGreeting(name:String , age:Int) :String =
  "hi , my name is " + name+" and i am " +age +" years old  "

println(aGreeting("david",12))

def aFactorial(n:Int):Int=
if (n<=0) 1
else n * aFactorial(n-1)


println(aFactorial(10))

def Fibonacci(n:Int):Int =
  if (n<=2) 1
  else Fibonacci(n-1) + Fibonacci(n-2)


println(Fibonacci(4))

def isPrime(n:Int):Boolean ={
  def isPrimeUntill(t:Int):Boolean =               // while using two function first one should have parenthesis
    if (t<=1) true
    else n%t !=0 && isPrimeUntill(t-1)

  isPrimeUntill(n/2)

}
println(isPrime(2003))
  println(isPrime(36*17))






}

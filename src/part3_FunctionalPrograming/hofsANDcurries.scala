package part3_FunctionalPrograming

object hofsANDcurries extends App{


  val superFunction:(Int,(String,(Int=>Boolean))=>Int) => (Int=>Int) = null
  //higher oder function (hof)

  // map , flatmap, filter is myList

  // function that applies a function n times over a value
  // ntimes (f,n,x)
  // ntimes (f,3,x)= f(f(f(x))) = ntimes(f,2,f(X))
  // ntimes (f,n,x) = f(f(...(f(x))= ntimes(f,n-1,f(x))

  def ntimes(f:Int=>Int,n:Int,x:Int) :Int =
    if(n<=0) x
    else  ntimes(f,n-1,f(x))    // functional programing is direct mapping of different functionality of mathematics

  val plusone:Int=>Int =_+1 //x+1   // (x:Int)=>x+1
                                               // by this u can compute higher order functioning
  println(ntimes(plusone,10,1))


  //ntimebetter=x=>f(f(f(...(x)))  we are using lambdaa here
  // increment10= ntimesbetter(plusone,10)= x=>plusone(plusone....(x))))
  //val y = increment10(1)
  def ntimebetter(f:Int=>Int ,n:Int):(Int=>Int) =
    if (n<=0) (x:Int)=>x
    else (x:Int)=>ntimebetter(f,n-1)(f(x))  // preserving x before so that we can change value on our need donot have to give before computing


  val plus10=ntimebetter(plusone,10)
  println (plus10(1))

  //curried function

  val superadder:Int=>(Int=>Int) = (x:Int)=>(y:Int)=>x+y
  val add3= superadder(3)
  println(add3(10))
  println(superadder(3)(4))

    // functions with multiple parameter lists
    def curriedFormatter(c:String)(x:Double):String= c.format(x)  // like this curried formatter can get as many parameter as we want // it is taking argument
                                                       // format is method of scala predef
    val standardFormat :(Double=>String) = curriedFormatter("%4.2f")  // partial function applications
    val preciseFormat : (Double=>String) = curriedFormatter("%10.8f")

/*
1) %: Indicates the start of the format specification.
2) 4: The minimum width of the field. This means the formatted number will occupy at least 4 characters. If the number is shorter, it will be padded with spaces.
3) .2: Specifies the precision. For floating-point numbers, this indicates the number of digits to be displayed after the decimal point (in this case, 2).
4) f: Stands for "floating-point number". This specifies that the value to be formatted is a floating-point number.
 */
    println(standardFormat(Math.PI))
    println(preciseFormat(Math.PI))


  /*

    1.  Expand MyList
        - foreach method A => Unit
          [1,2,3].foreach(x => println(x))

        - sort function ((A, A) => Int) => MyList
          [1,2,3].sort((x, y) => y - x) => [3,2,1]

        - zipWith (list, (A, A) => B) => MyList[B]
          [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]

        - fold(start)(function) => a value
          [1,2,3].fold(0)(x + y) = 6

    2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

    3.  compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))



   */


  def tocurry(f:(Int, Int) => Int): (Int => Int => Int) =
    x=>y => f(x,y)

  def fromcurry(f:(Int => Int => Int)) :(Int, Int) => Int=
    (x,y) =>f(x)(y) //easy to write but not to think this is a non trivial function

 // functionX
  //def compose(f:Int=>Int , g:Int=>Int) :Int=>Int =  x =>f(g(x))
  def compose[A,B,T](f: A=>B, g: T=>A):T=>B=
      x => f(g(x))  // the error coming becuase of indentation

  def andthen[A,B,C](f:A=>B , g:B=>C) :A=>C =
    x =>g(f(x))                      // ALWAYS RELATE TYPE FUNCTION WITH MATHS SETS RELATIONS AND FUNCTIONS
  // LIKE HERE IT IS composition of functions abstract maths work

  def superadder2:(Int=>Int=>Int) = tocurry(_+_)
  val add4 = superadder2(4)
  println(add4(17))

  val simpleadder=fromcurry(superadder)
  println(simpleadder(4,17))

  val add2= (x:Int)=>x+2
  val times3=(x:Int)=>x*3
  val composed=(compose(add2,times3))
  val ordered = (andthen(add2, times3))
  println(composed(33))

  println(ordered(33))
}

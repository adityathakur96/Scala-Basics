package part1basics

object prime extends App{
  def isPrime(n: Int): Boolean = {


    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }


    isPrimeTailRec(n / 2, true)  // here the exception incured that i have to use parenthesis here on next
    // function while in privious i didint use but when i removed now after doing it one time it works well with no error
    // i think compiler learns itself
  }
  println(isPrime(2003))
  println(isPrime(629))

}

package part1basics

object prime extends App{
  def isPrime(n: Int): Boolean = {


    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }


    isPrimeTailRec(n / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

}

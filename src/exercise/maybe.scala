package exercise
// maybe always denote in functional programmming as optional values it is at most one element
abstract class maybe [+T]{


  def map[B](f:T=>B): maybe[B]
  def flatMap[B](f:T=>maybe[B]) :maybe[B]
  def filter(p:T=> Boolean) :maybe[T]
}

case object maybenot extends maybe [Nothing]{
  def map[B](f:Nothing=>B) :maybe[B]=maybenot
   def flatMap[B](f:Nothing=>maybe[B]) :maybe[B]=maybenot
   def filter(p:Nothing=>Boolean):maybe[Nothing] = maybenot

}

case class just[+T](value:T)extends maybe[T] {

  def map[B](f: T => B): maybe[B] = just(f(value))

  def flatMap[B](f: T => maybe[B]): maybe[B]= f(value)

  def filter(p: T => Boolean): maybe[T] =  //  p is predicate
    if (p(value)) this
    else maybenot

}

object maybetest extends App{

  val just3 = just(3)
  println(just3)
  println(just3.map(_*2))
  println(just3.flatMap(x=>just(x % 2==0)))
  println(just3.filter(_%2==0))


}
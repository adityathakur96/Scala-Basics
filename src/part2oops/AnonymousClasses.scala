package part2oops

object AnonymousClasses extends App {
  // here we have instantiated the abstract classes  but how some tricks here
  abstract class Animal {
    def eat: Unit
  }
  // anonymous class
  // so how the abstract class instantiated


  val Funnyanimal = new Animal {
    override def eat: Unit = println("hahahahahahah") // while we instantiated the abstract class like this without above class AnonymousClasses$$anon$1
    // always make the methods for the abstract classes so that compiler make the non abstract  classes in the background
  }

  println(Funnyanimal.getClass) // getClass ANOTHER INBUILT METHOD

  // always make sure to pass the proper parameter to call for  the anonymous class


  class Person(name: String) {
    def sayHi: Unit = println(s"hello my name is $name,and i love learning scala ")
  }

  val jim = new Person("jim ") {
    override def sayHi: Unit = println(s"hello my name is jim,and i love learning scala ")
    // always put parameter for the classes
  }
  /*
    Exercises:
    1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2.  Generic trait MyTransformer[-

    A, B] with a method transform(A) => B
    3.  MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */

}

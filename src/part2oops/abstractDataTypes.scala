package part2oops

object abstractDatatypes extends App {

    abstract class Animals {
      val creatureType: String ="wild"  // abstract classes can have abstract and non abstract types
      def eat: Unit
    }

    class Dog extends Animals {
      override val creatureType: String = " canine"

      def eat: Unit = println("crunch,crunch") // override keyword is not mandantory for the inherit members of abstract clas
    }

    // traits
    // these are the ultimate abstract  datatypes in the scala
    trait carnivore {
      def eat(animals: Animals): Unit
      def prefferedMeal:String = " Fresh meat "// trrait can also have abstract and non abstract types
    }
    trait coldebloded{

    }

    class Crocodile extends Animals with carnivore with coldebloded {
     override val creatureType: String = "croc"
      val eat: Unit = println("nomnomnom")

      def eat(animals: Animals): Unit = println(s"iam a croc and iam eating ${animals.creatureType}")
      // here animal.creatureType will return most overriden implementation
    }

    val dog = new Dog
    val croc = new Crocodile
    croc.eat(dog)
/*
   traits vs abstract class
   1-trait donot have the constructor parameter
    2-mutiple traits may be inherited but class can be only one by the same class
   3- trait = behavior , abstract class = "thing"
*/
}

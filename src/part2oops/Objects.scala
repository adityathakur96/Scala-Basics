package part2oops

object Objects { // entends App have def main methods

  // scala doesnot have class level functionality that is it doesnot support "static"

  object Person { // type + its only instance
    // " Staic"/"class" - level functionality
      val N_Eyes = 2 // object can be define in a similar way in scala like the classes it can have var , val and methods (def)

    def canFly: Boolean = false

    //factory method =>
    // def from (mother:Person , father:Person):Person = new Person("bobby")
    def apply(mother: Person, father: Person): Person = new Person("bobby") //factory method apply method serves as factory method 
     // companions can access each others private members
  }

  class Person(val name: String) {

    // instance level functionality
  }

  // class and object with same name called companions
  def main(agrs: Array[String]): Unit = {
    println(Person.N_Eyes)
    println(Person.canFly)

    // scala objects = SINGLETON INSTANCE
    val mary = Person
    val john = Person

    println(mary == john) // true
    // as objects are singleton instance and all extra instance made will be same or equal to say
    val marry = new Person("marry")
    val John = new Person("John")
    println(marry == John) // false
    // as classes can have multiple instance

    //  val bobby= Person.from(marry,John)
    val bobby = Person.apply(marry, John) // it is also equal to =>  val bobby= Person(marry,John)

    // scala applications are  scala object with method below
    // def main (agrs: Array[String]):Unit ={} it replace the EXTENDS APP ABOVE
//
  }
}

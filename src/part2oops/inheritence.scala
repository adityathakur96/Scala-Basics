package part2oops

object inheritence extends App{
 // single class inheritence
  sealed class Animals { // if i were to extend the ANimals in another file it will be ristricted becuase of sealing 
// final  class Animals{ // if the keyword final given to class this prevent the entire class from being extended or from inherited
  val creaturetype = "wild"
  private def eat = println(" nomnom") // keyword private makes methods private to other class in inheritence
   protected def eating = println(" nomnom") // final  def eats = println(" nomnom") it will not be override by the derive class
  def eats = println(" nomnom")
  // protected makes it protect then we can only access it in its own class like private but can access in
  // in sub class
  def eatme = println(" nomnom")
 }


  class Cat extends Animals{          // single class inheritemce  extends Animals means cat can inherit non private members of class animals
   eating
    def Crunch= {
      eating                                    // like this we can calls inside the subclass but still inaccesible to outside class
      println("Crunch Crunch ")
    }
  }

  val cat = new Cat
  cat.eatme // if private and protected then cant access
  // constructors
  class Person(name:String,age:Int){
   def this(name:String) =this(name,0)//auxilary constructor
  }
  class Adults (name:String , age:Int ,idcard:String) extends Person(name)

  //overriding
//  class Dog( override val creaturetype:String) extends Animals {  // we can put overrie in the parameter section of class
  // override  val creaturetype = "domestic"
//override def eats =println ("crunch,crunch") // we cannot override the protected memebers of superclass
// override rewite the values of protected and public memebers of superclass by this we can also access
   // the protected members outside the subclass also but not with private class
//}
  class Dog(dogtype:String) extends Animals {
   override val creaturetype=dogtype  // its the same as above
   override def eats = {
    super.eats // it will refer to method eats in superclass so it will print nomnom too on console
    println ("crunch,crunch")
   }
  }
val dog = new Dog("k9" )
dog.eats
println(dog.creaturetype)


 // type substitution (broad: polymorphism)
val unknownAnimal: Animals=new Dog("k9") //val unknownAnimal: Animals declares a variable unknownAnimal with the type Animals.
 // This means unknownAnimal can hold a reference to any instance of Animals or any of its subclasses.
 //new Dog("k9") creates a new instance of the Dog class,
 // passing "k9" as a constructor argument.
 unknownAnimal.eats // its use the overriden implementation of eat although its pass with animals but its the  instance of new Dog
 // so it take overriden implementation
 // MEHTOD CALL ALWAYS GOES TO MOST OVERRIDENN VERSION whenever possible


 // overriding vs overloading
 //overriding  means different implementation in derived classes
 // overeloading means supplying multiple methods and signature with the same name in class

 // super

 //preventing  override
 // 1. use keyword final final will prevent derive class to overirde the methods
// 2.final can be used in the class itself on entire class
//3. seal the class = extends classes IN THIS FLE ONLY , but prevents from extension in other files




}

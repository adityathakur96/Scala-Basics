package part2oops

object Generics extends App{

  class myList[+A] {   // the type A in square brackets are generic type
    //use the type A  inside the class defination
 def add[B >:A](element: B):myList[B] = myList[B] // if in list of A we put B which is supertype of A then it will give myList of B
    // trait can also be type parameterized
    /*
    A=cat
    B = animals then mylist become list of animal
     */
  }
  class myApp[key, value] // you can pass as many as type parameter in class as generic type
  val listofIntegers =new myList[Int]
  val listofStrings = new myList[String]

// MORE ABOUT THIS PROBLEM AND VARIANCE WE GONNA STUDY IN ADVANCE SECTION 

  // generic methods

  object myList {   // objects cannot bne type parameterized
    def Empty [A] :myList[A]= ???    //we call it empty type parameterized with A
    // we can use the methods with type parameterized  and make them generic methods

  }
  val emptyListofIntegers= myList.Empty[Int]

  //variance problem
  class Animal
  class cat extends Animal
  class dog extends Animal

  // 1. yes the list of class cat (list[cat]) extends list of animal class(list[animal]) it is equal to covariance

  class CoveriantList[+A]
  val animal: Animal=new cat // what is the meaning of +A here because by adding plus error at below line last word got removed
val animalList: CoveriantList[Animal] = new CoveriantList[cat]  // we can replace list of animal with list of cat
  // as cat comes under animals( cat is subtype of animal)
//animalList.add(new dog) ??? hard question ans of this question is that we return the list of animal
// 2. no , the list of class cat (list[cat]) donot extends list of animal class(list[animal])
// it is called invariance list

class invariantList[A]
val invariantAnimalList : invariantList[Animal]= new invariantList[Animal] // it should be animal at last and should not be anything if something wlse it will throw error on your face

// 3. hell no , contravariance which is opposite of covariance


class Trainer[-A]

  val trainer: Trainer[cat] = new Trainer[Animal]





// class contravariantList[-A]
// val contravariantList: contravariantList[cat] =new contravariantList[Animal] // wwe can replace list of cats with list of animals
  // (but how can you replace list of cat with list of animal its contradictory as cat is subtype of animal)

/*
Covariant (+A): List[cat] can be used as List[Animal].
Invariant (A): List[cat] and List[Animal] are separate and cannot be used interchangeably.
Contravariant (-A): List[Animal] can be used as List[cat].
 */

//bounded types it will confide the use of generic classes for certain classes which are subclass of different type or superclass of different type

class Cage [A <: Animal] (animal:A)  //class cage only allow type  parameter A which are subtype of Animal
// [A >: Animal] it means class cage only allow type  parameter A which are supertype  of Animal
val cage = new Cage(new dog)

//class car
//val car= new Cage (new car)  it a error aas car is not subtype of animal

//  IT WILL BE HELPFULL WHEN WE MAKE GENERIC FRAMEWORKS

// EXPAND MYlIST WITH generic


}

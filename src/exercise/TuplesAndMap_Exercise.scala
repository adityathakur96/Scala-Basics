package exercise

import scala.annotation.tailrec

// this is a quite heavy exercise so make it count and study thoroughly so that u can understand it as maps and tuple has high usecase


object TuplesAndMap_Exercise extends App{
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = { // if i say set + value then it will return a new set with that element added using sets guarrenties that our set that unique values only
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a)) // + always create a new pairing on the map replacing old pairing in the result
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)  // output :Map(Bob -> Set(), Mary -> Set())
  println(friend(network, "Bob", "Mary")) // output : Map(Bob -> Set(Mary), Mary -> Set(Bob))
  println(unfriend(friend(network, "Bob", "Mary"),"Bob","Mary")) // output is : Map(Bob -> Set(), Mary -> Set())
  println(remove(friend(network, "Bob", "Mary"),"Bob")) // output : Map(Mary -> Set()) as mary to empty set because bob is completely removed from the network then it also removed from friend list

  // Jim , Bob , Mary build a network in which , jim and bob are friends and bob and mary are friend but jim and mary are not
  val people= add(add(add(empty, "Bob"), "Mary"),"Jim")
  val jimBob = friend(people,"Bob","Jim")
  val testNet= friend(jimBob,"Bob","Mary")
  println(testNet) // output : Map(Bob -> Set(Jim, Mary), Mary -> Set(Bob), Jim -> Set(Bob))

  def nFriends(network: Map[String, Set[String]], person: String):Int=
    if (!network.contains(person)) 0
    else network(person).size



  println( nFriends(testNet,"Bob")) // output : is 2

  def mostFriends(network: Map[String, Set[String]]):String =
    network.maxBy(pair=>pair._2.size)._1


  println(mostFriends(testNet)) //output :Bob



  def nPeopleWithNofriends(network:Map[String,Set[String]]):Int =
    //network.view.filterKeys(k=>network(k).isEmpty).size
   // network.view.count(pair=>pair._2.isEmpty)  // instead of filtering keys we should go for pairings here we can replace filter and size by count
    // here count method counts the the no. of pairs for which this lambda is true  also we can change it from pair=>pair to shorthand notations that would be _
    network.view.count(_._2.isEmpty)


  println(nPeopleWithNofriends(testNet)) // output is : 0

  def socialConnection(network: Map[String, Set[String]], a: String,b:String):Boolean = {
    @tailrec
    def bfs(target:String,consideredPeople:Set[String],discoveredPeople:Set[String]) : Boolean ={
      if (discoveredPeople.isEmpty) false
      else{
        val person= discoveredPeople.head                   // this is quite heavy so make a diagram or something to understand this whole function
        if(person == target) true
        else if (consideredPeople.contains(person)) bfs(target,consideredPeople,discoveredPeople.tail)
        else bfs(target,consideredPeople+person,discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b,Set(),network(a)+a)
  }

  println(socialConnection(testNet,"Mary","Jim"))  // output is : true
  println(socialConnection(network,"Mary","Bob"))  //output is : False


}

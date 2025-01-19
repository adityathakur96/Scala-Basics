package part3_FunctionalPrograming

import scala.util.Random // scala and java are inter change able as they both have Random function

object Options extends App{

  val myFirstOption : Option[Int]= Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption) // some(4)

  println(noOption) // None

  // options are to deal with unsafe APIs
  def unsafeMethod():String= null
 // val result = Some(unsafeMethod()) // but it is WRONG as some should have have valid value as in this case it can return null value
  val result = Option(unsafeMethod()) // option will itself make some or none depending on method value
 println(result) // the whole point of having options is that we should not do null checks ourself

 // we should use option in CHAINED METHODS

 def  backupmethod():String= "a valid result "
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupmethod())) // if first is null then next part is your backup

  //Design unsafe apis
  def betterUnsafemethod():Option[String] = None
  def betterbackupmethod ():Option[String] = Some("A valid result ")  // when u work with better apis u get better result

  val betterChaindResult = betterUnsafemethod() orElse betterbackupmethod()


  // functions as options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // here it is getting 4 but   //  it's unsafe as it is trying to get a value from no pointer it wil throw a no pointer exception
  // do not use this it will break the general idea of option

  // map, filter, flatMap
  println(myFirstOption.map(_*2))//Some(8) // _ is short hand notation for x=>x
  println(myFirstOption.filter(_>10))// None  // filtering can turn into option with value to option of no values depending upon the predicate matches
  println(myFirstOption.flatMap(x=>Option(x*10)))// Some(40)

  // for comprehensions

  /*
   Exercise
   */

  val config :Map[String,String]= Map(
    //fetched from elsewhere (like from configuration file) as you don't have certainty that the below value is there or not , it might be or might not be here  as these fetched from elsewhere
    "host"->"176.45.36.1",
    "port"->"80"
  )

  class Connection{
    def connect= " Connected"  // connect to some server

  }
  //Companion Object: Contains a factory method apply that randomly returns a Connection or None.
  object Connection {
    val random = new Random(System.nanoTime())
    def apply (host:String,port:String):Option[Connection] =
      if (random.nextBoolean()) Some(new Connection) //random.nextBoolean() is called, which returns either true or false with equal probability.
      else None
  }
//This random behavior simulates the uncertainty of establishing a connection, which can either succeed or fail.
  // try to establish the connection , if so - println the connect method
  val host = config.get("host")
  val port= config.get("port")
  /*
  if (h!=null)
    if(p!=null)
      return Connection.apply(h,p)

   else return null
  this is the equivalent imperative code for the below functional code does here
   */
  val connection = host.flatMap( h=>port.flatMap(p=>Connection.apply(h,p)))
  /*
  if (c!= null)
     return c.connect
  else return null
   */
  val connectionStatus = connection.map(c=>c.connect)  //c=>c.connect is lambda function also Anonymous Functions: c => c.connect is an anonymous function,
  // meaning it doesn't have a name and is defined in place. lambda function (also known as an anonymous function)
  /*
  if(connectionStatus == null) println(none)
   else println(some(connectionStatus.get))
   */
  println(connectionStatus) // output is : Some( Connected)  but it all depend on random.nextBoolean()
  /*
  if(status!=null)
   println(status)
  otherwise don't do anything
   */
  // all the comments here denote there below functional code as there imperative code
  connectionStatus.foreach(println) // output is : Connected
  // Executes a side effect (like printing) if the Option is Some.



  // below is shorthand solution or chained solution for the above one// chained calls
  config.get("host")
    .flatMap(host=>config.get("port")
      .flatMap(port=>Connection(host,port))
        .map(connection=>connection.connect))
    .foreach(println) // for whole of this do show connection when random no. generator hit his marks to give .nextBoolean true value


  // for above codes we have another solution that is to use for comprehensions
   val forconnectionStatus= for {
     host<-config.get("host")
     port<-config.get("port")
     connection<-Connection(host, port)
   } yield connection.connect

   forconnectionStatus.foreach(println)  // it will come connected or none as said above also due to random no. generator
  

}

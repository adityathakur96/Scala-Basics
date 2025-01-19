package part2oops



import playground.{cindrella=>Princess, princeCharming} // for using the class cindrella i have to import the that package

                              // cindrella=>Princess  name alias as if we have same name package and in same file like here

  import java.util.Date
  import java.sql.{Date=> sqlDate}



//import playground._  // _ means that all the things inside any package
object PackagingandImports extends App{

// package members are accessible by their single name

val writer =new Writer ("aditya ", "rock the jvm ", 2104)



// if you are not in the proper package you have to import the package
 val princess = new Princess // there is other way to do this without importing the package and that is
//val princess = new playground.cindrella
//packages are in hierarchy
// matching folder structure as cindrella is in palyground package

//package object

sayHello
println(Speec_Of_Light)
val prince = new princeCharming

// val d = new Date() // if not correct as it will select the first date import for its first date  why we use arrow sign as above for cindrella


//1. use fully quallified name

//val date = new Date(2018,4,4)
//val sqldate = new java.sql.Date(2012,2,2)

// 2 we can use the alias to the date

//val date = new Date(2018,4,4)
// val sqldate = new sqlDate(2012,2,2)


//default import
// compiler itself import them without your interpretation
// like java.lang  - string , objects , exception
// scala - int , Nothing , Functions
// scala.predef - println(), ??? 





}

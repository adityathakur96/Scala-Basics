package part2oops

import part2oops.Enums.Permission.read

object Enums {

  enum Permission {                       // it is sealed data type
    case read, write, execute,none
    def openDocument(): Unit =
      if (this==read) println("opening a document ....")
      else println("reading not allowed ")
  }

  val somePermision :Permission = Permission.write

  // enums can take constructor argument
  enum PermissionWithBit(bits:Int) {
    case read extends PermissionWithBit(4)   //100
    case write extends PermissionWithBit(2)  //010
    case execute extends PermissionWithBit(1)  //001
    case none extends PermissionWithBit(0)     //000
  }

  // we can have companion object for enums
  object  PermissionWithBit{
    def fromBit(bit:Int) :PermissionWithBit= // whatever
      PermissionWithBit.none
  }

  // standard api of enum

  val somePermmisionOrdinal = somePermision.ordinal      // ordinal is method inbuilt in scala
   val allPermission= PermissionWithBit.values       // values is function n scala  that is array of all possible values of enum
val readPermission :Permission = Permission.valueOf("read") /// this will happen only to no constructor enum  // permission.read 


  def main (args:Array[String]): Unit ={
    somePermision.openDocument()
    println(somePermmisionOrdinal)   // ordinal give the index of whatever is given in the code
  }

}

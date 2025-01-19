package part1basics

//object defaultags extends App{
//
//  def trFact (n:Int,acc:Int=1):Int        =           // we can set def argument to any valuee so that if we didnt give the value we can take it from here
//    if (n<=1) acc            
//    else trFact(n-1,n*acc)
//
//    val fact10 =trFact(10) // here acc will be 1 even if we didnt set that up here as above we have done it 
//    // but if the leading parameter is default and we didnt put his value then compiler give error 
//
//    /*
//    we can bypass the compiler error 
//    1. pass in every leading argument 
//    2. name the argument like trfact(acc=2) if it shows error here it donot show example below
//     */
//    def savePicture(format: String = "jpg", width: Int = 600, height: Int = 700):Unit = 
//      {println("picture saved")}
//
//    savePicture(width = 500) // and other take default value
//      savePicture(height=600 ,width=800 ,format="bmp") // agge piche bhi kar sakte hai 
//
//
//}

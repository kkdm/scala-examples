package example

object RegexExample extends App {
  val pattern = "^[hH]ello$".r
  val greetingUpper = "Hello"
  val greetingLower = "hello"
  val greetingOther = "Good morning"
  
  def sayBackHello(g: String): Unit = {
    g match {
      case pattern(_*) => println("Scala: Hello :)")
      case _ => println("Scala: :(")
    }
  }

  println(s"Me: ${greetingUpper}.")
  sayBackHello(greetingUpper)
  
  println(s"Me: ${greetingLower}.")
  sayBackHello(greetingLower)

  println(s"Me: ${greetingOther}.")
  sayBackHello(greetingOther)


  val patternCapture = "^[hH]ello\\,? *(\\w+)\\W+$".r
  val greetingName1 = "Hello, Scala!"
  val greetingName2 = "Hello Scala."

  greetingName1 match {
    case patternCapture(name) => println(s"Hi, ${name.trim}.")
    case _ => println(":(")
  }

  greetingName2 match {
    case patternCapture(name) => println(s"Hi, ${name.trim}.")
    case _ => println(":(")
  }

  val patternPartial = "[hH]el".r
  val greetingPartial = "Hello"

  greetingPartial match {
    case patternPartial(_*) => println("Partial match")
    case _ => println(":(")
  }
}

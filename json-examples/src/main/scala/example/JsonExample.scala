package example

import spray.json._
import DefaultJsonProtocol._

object JsonExample extends App {
  val json = """{"key": "value"}"""
  val jsonAst = json.parseJson
  println(jsonAst.prettyPrint)

  println("""{"key": null}""".parseJson.prettyPrint)

  println(List(1, 2, 3).toJson.prettyPrint)

  case class Person(name: String, age: Int)

  object MyJsonFormat extends DefaultJsonProtocol {
    implicit val personFormat = jsonFormat2(Person)
  }

  import MyJsonFormat._

  val p = Person("kkdm", 100)
  println(p.toJson.prettyPrint)
}

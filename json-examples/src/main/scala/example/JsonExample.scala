package example

import spray.json._
import DefaultJsonProtocol._

object JsonExample extends App {
  val json = """{"key": "value"}"""
  val jsonAst = json.parseJson
  println(jsonAst.prettyPrint)

  println("""{"key": null}""".parseJson.prettyPrint)

  println(List(1, 2, 3).toJson.prettyPrint)

  val nestedStr = """{"key": "value", "nest1": {"key": "value", "nest2": {"key": "value"}}}"""
  println(nestedStr.parseJson.prettyPrint)

  case class Person(name: String, age: Int)

  object MyJsonFormat extends DefaultJsonProtocol {
    implicit val personFormat = jsonFormat2(Person)
  }

  import MyJsonFormat._

  val p = Person("kkdm", 100)
  println(p.toJson.prettyPrint)

  case class Me(name: String, age: Int, skill: List[String])
  implicit val meFormat = jsonFormat3(Me)

  val me = Me("kkdm", 25, List("Python", "Shell", "Scala?"))
  println(me.toJson.prettyPrint)

  case class Child(name: String, age: Int, sex: String)
  case class Father(name: String, age: Int, children: List[Child])

  implicit val childrenFormat = jsonFormat3(Child)
  implicit val fatherFormat = jsonFormat3(Father)

  val bob = Child("bob", 6, "Male")
  val sasha = Child("sasha", 4, "Female")
  val john = Father("john", 34, List(bob, sasha))

  println(john.toJson.prettyPrint)

  import scala.io.Source
  val file = Source.fromFile("src/main/scala/example/example.json").mkString

  println(file.parseJson.prettyPrint)

  implicit val memberFormat = jsonFormat3(Member)
  implicit val eventFormat = jsonFormat(Event, "name", "member-count", "max-member-count", "members")
  implicit val myDayFormat = jsonFormat2(MyDay)

  case class Member(name: String, age: Int, country: String)
  case class Event(name: String, memberCount: Int, maxMemberCount: Int, members: List[Member])
  case class MyDay(date: String, events: List[Event])

  val kkdm = Member("kkdm", 25, "Japan")
  val yu = Member("yu", 27, "China")
  val ev = Event("trekking", 2, 4, List(kkdm, yu))
  val day = MyDay("2018-09-10", List(ev))
  println(day.toJson.prettyPrint)

  val file2 = Source.fromFile("src/main/scala/example/example.json").mkString
  println(file2.parseJson.convertTo[MyDay])
}

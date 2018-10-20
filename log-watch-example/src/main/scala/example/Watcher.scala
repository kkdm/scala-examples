package example

import akka.actor.{Actor, Props}

object Watcher {
  def props(): Props = Props(new Watcher)
}

class Watcher extends Actor {

  def receive = {
    case Target(p) => {
      println(s"Start ${self}")
      println(s"Loading log ${p}")
      sender ! Finish(self)
    }
    case _ => println("Wrong message")
  }
}

package example

import akka.actor.ActorRef

case object SystemStart
case class Finish(obj: ActorRef)

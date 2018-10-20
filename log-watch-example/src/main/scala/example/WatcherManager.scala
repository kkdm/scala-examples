package example

import akka.actor.{Actor, Props, Terminated}
import akka.routing.RoundRobinPool
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._

/**
 * WatchManager is called by mainSystem to be started.
 */
object WatcherManager {
  def props(watchList: List[String]): Props = Props(new WatcherManager(watchList))
}

class WatcherManager(watchList: List[String]) extends Actor {
  val stopStrategy = OneForOneStrategy() { case e => Stop }
  val router = context.actorOf(RoundRobinPool(2, supervisorStrategy = stopStrategy).props(Watcher.props()), "router1")

  def receive = {
    case SystemStart => {
      for (p <- watchList) router ! Target(p)
      println("Finished sending message to all")
    }
    case Terminated(a) => {
      println(s"${a} terminated.")
    }
    case Finish(a) => {
      println(s"${a} did it!")
    }
  }
}

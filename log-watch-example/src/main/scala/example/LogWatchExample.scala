package example

import akka.actor.ActorSystem
import scala.concurrent.duration._

object LogWatchExample extends App {
  val watchList = List("/path/to/test.log", "/path/to/test1.log", "/path/to/test2.log", "/path/to/test3.log", "/path/to/test4.log")
  val system = ActorSystem("mainSystem")
  val actor = system.actorOf(WatcherManager.props(watchList), "manager")

  import system.dispatcher

  system.scheduler.schedule(0 seconds, 10 seconds, actor, SystemStart)
}



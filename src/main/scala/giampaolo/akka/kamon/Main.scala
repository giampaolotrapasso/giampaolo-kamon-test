package giampaolo.akka.kamon

import akka.actor._

import kamon.Kamon

import scala.concurrent.duration._

object TestApp extends App {
  // start kamon very first
  Kamon.start

  val system = ActorSystem("giampaolo")

  import system.dispatcher

  val greeter = system.actorOf(Props[Greeter], name = "greeter")

  system.scheduler.schedule(
    0 milliseconds,
    500 milliseconds,
    greeter,
    RequestHello("hi")
  )
}
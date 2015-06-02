package giampaolo.akka.kamon

import java.lang.System.nanoTime

import akka.actor.{Actor, ActorLogging}

class Greeter extends Actor with ActorLogging {

  def receive = startReceive

  def startReceive: Receive = {
    case RequestHello(text) =>
      val s = s"RequestHello $text ${nanoTime()}".toUpperCase.reverse.toCharArray
      println(s)
  }
}

case class RequestHello(text: String)

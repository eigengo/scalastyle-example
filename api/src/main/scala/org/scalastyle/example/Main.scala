package org.scalastyle.example

import spray.can.Http
import akka.io.IO
import akka.actor.{Props, ActorSystem}
import spray.routing.{HttpServiceActor, Route}

class Main(route: Route) extends HttpServiceActor {
  def receive: Receive = runRoute(route)
}

object Main extends App with CalculatorService {
  implicit val system = ActorSystem()
  import system.dispatcher

  val calculator = system.actorOf(Props[CalculatorActor])

  val service = system.actorOf(Props(new Main(
    calculatorRoute(calculator)
  )))

  IO(Http) ! Http.Bind(service, "0.0.0.0", port = 8080)

  System.in.read()
  system.shutdown()
}
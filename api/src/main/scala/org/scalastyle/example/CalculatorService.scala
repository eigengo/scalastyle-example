package org.scalastyle.example

import spray.routing.{Directives, Route}
import scala.concurrent.ExecutionContext
import akka.actor.ActorRef
import spray.httpx.marshalling.{MetaToResponseMarshallers, BasicToResponseMarshallers}

trait CalculatorService extends Directives with BasicToResponseMarshallers with MetaToResponseMarshallers {
  import Timeouts._
  import akka.pattern.ask

  def calculatorRoute(calculator: ActorRef)
                  (implicit ctx: ExecutionContext): Route =
    path("square" / IntNumber) { i =>
      get {
        complete { (calculator ? i).map { case i: Int => <html>{i}</html>} }
      }
    }

}

package org.scalastyle.example

import akka.actor.Actor

class CalculatorActor extends Actor {

  def receive = {
    case i: Int => sender ! i * i
  }

}

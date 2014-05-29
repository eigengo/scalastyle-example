package org.scalastyle.example

import akka.util.Timeout
import java.util.concurrent.TimeUnit

private[example] object Timeouts {

  implicit val internalTimeout = Timeout(5000, TimeUnit.MILLISECONDS)

}

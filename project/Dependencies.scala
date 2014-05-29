object Dependencies {
  import sbt._
  import Keys._

  object akka {
    val akka_version = "2.3.2"

    val actor   = "com.typesafe.akka" %% "akka-actor"   % akka_version
    val testkit = "com.typesafe.akka" %% "akka-testkit" % akka_version
  }

  object spray {
    val spray_version = "1.3.1"

    val can     = "io.spray" % "spray-can"     % spray_version
    val http    = "io.spray" % "spray-http"    % spray_version
    val httpx   = "io.spray" % "spray-httpx"   % spray_version
    val routing = "io.spray" % "spray-routing" % spray_version
  }

  val specs2           = "org.specs2"             %% "specs2"                % "2.3.11"
}

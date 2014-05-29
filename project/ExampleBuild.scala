import sbt._
import Keys._

object ExampleBuild extends Build {

  override val settings = super.settings ++ Seq(
    organization := "org.scalastyle.example",
    version := "0.4-SNAPSHOT",
    scalaVersion := "2.10.4"
  )

  import sbtrelease.ReleasePlugin._

  def module(dir: String, extraSettings: Seq[Setting[_]] = Nil) = Project(id = dir, base = file(dir), 
    settings = BuildSettings.buildSettings ++ releaseSettings ++ extraSettings)
  
  import Dependencies._

  lazy val root = Project(
    id = "parent", 
    base = file("."), 
    settings = BuildSettings.buildSettings,
    aggregate = Seq(core, api)) dependsOn api

  lazy val core = module("core") settings (
    libraryDependencies += akka.actor
  )
  lazy val api = module("api") dependsOn core settings (
    libraryDependencies += spray.can,
    libraryDependencies += spray.routing
  )

}

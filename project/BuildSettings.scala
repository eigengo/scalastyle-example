object BuildSettings {
  import sbt._
  import Keys._
  import org.scalastyle.sbt.ScalastylePlugin

  lazy val buildSettings = 
    Defaults.defaultSettings ++ 
    ScalastylePlugin.Settings ++ 
    Seq(
      org.scalastyle.sbt.PluginKeys.config := file("project/scalastyle-config.xml"),
      scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.7", "-deprecation", "-unchecked", "-Ywarn-dead-code"),
      scalacOptions in (Compile, doc) <++= (name in (Compile, doc), version in (Compile, doc)) map DefaultOptions.scaladoc,
      javaOptions += "-Xmx2G",
      outputStrategy := Some(StdoutOutput)
  )

}

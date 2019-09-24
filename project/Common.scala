
import sbt.Keys._

object Common {
  lazy val Settings = Seq(
    organization                 := "com.wardziniak",
    name                         := "kafka-connect-plugins",
    scalaVersion                 := Versions.Scala,
    scalacOptions +=            "-Xexperimental",
    version := Versions.AppVersion,
    libraryDependencies ++= Seq(Dependencies.kafkaConnectApi, Dependencies.kafkaConnectTransforms, Dependencies.scalaLogging, Dependencies.logbackClassic)
  )
}

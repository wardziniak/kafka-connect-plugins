import sbt.{ModuleID, _}

object Dependencies {
  val kafkaConnectApi: ModuleID = "org.apache.kafka" % "connect-api" %  Versions.Kafka
  val kafkaConnectTransforms: ModuleID = "org.apache.kafka" % "connect-transforms" % Versions.Kafka
  // Logging
  lazy val scalaLogging: ModuleID = "com.typesafe.scala-logging" %% "scala-logging" % Versions.ScalaLogging
  lazy val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % Versions.LogbackClassic

  // Test
  val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.ScalaTest % "test"
}

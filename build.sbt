val vSpark = "1.3.1"
val sparkCore             = "org.apache.spark"         %% "spark-core"                % vSpark
val sparkCassandra        = "com.datastax.spark"       %% "spark-cassandra-connector" % "1.3.0-M1"
val cassandraDriver       = "com.datastax.cassandra"    %  "cassandra-driver-core"     % "2.1.6"

import sbt.complete.DefaultParsers._

lazy val root = (project in file(".")).
  settings(
    scalaVersion := "2.11.6",
    updateOptions := updateOptions.value.withCachedResolution(true),  // this breaks it
    dependencyOverrides += cassandraDriver,   // this fixes it!
    libraryDependencies ++= Seq(
      sparkCore,
      cassandraDriver,
      sparkCassandra
    ),
    deps := {
      val matchString = (Space ~> token(StringBasic,"<search string>")).parsed
      val classpath = (fullClasspath in Compile).value
      val found = classpath.map(_.data.toString).filter(_.contains(matchString))
      found foreach println
    }
  )

lazy val deps = inputKey[Unit]("search classpath")

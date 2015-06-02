val sparkCore             = "org.apache.spark"         %% "spark-core"                            % "1.2.2"
val sparkMllib            = "org.apache.spark"         %% "spark-mllib"                           % "1.2.2"
val sparkCassandra        = "com.datastax.spark"       %% "spark-cassandra-connector"             % "1.2.1"

lazy val root = (project in file(".")).
  settings(
    scalaVersion := "2.11.6",
    libraryDependencies ++= Seq(
      sparkCore,
      sparkCassandra,
      sparkMllib
    ) 
  )


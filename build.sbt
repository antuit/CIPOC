name := "cipoc"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.1.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports")


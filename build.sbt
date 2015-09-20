name := """play24-slick3-multidb-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "1.0.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.0.1",
  "com.typesafe.slick" %% "slick-codegen" % "3.0.1",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  specs2 % Test,
  "com.h2database" % "h2" % "1.4.187" % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

javaOptions in Test += "-Dconfig.resource=application.test.conf"

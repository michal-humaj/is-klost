name := "is-klost"

version := "1.0"

javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")

lazy val `is-klost` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.feth" % "play-authenticate_2.11" % "0.6.8",
  "com.google.api-client" % "google-api-client" % "1.19.1",
  "com.google.apis" % "google-api-services-calendar" % "v3-rev114-1.19.1",
  "com.google.http-client" % "google-http-client-jackson2" % "1.19.0",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "joda-time" % "joda-time" % "2.7",
  "org.apache.poi" % "poi-ooxml" % "3.11",
  "org.apache.poi" % "poi" % "3.11",
  "org.json" % "json" % "20141113",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers ++= Seq(
  "Apache" at "http://repo1.maven.org/maven2/",
  "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
  "play-easymail (release)" at "http://joscha.github.io/play-easymail/repo/releases/",
  "play-easymail (snapshot)" at "http://joscha.github.io/play-easymail/repo/snapshots/",
  "play-authenticate (release)" at "http://joscha.github.io/play-authenticate/repo/releases/",
  "play-authenticate (snapshot)" at "http://joscha.github.io/play-authenticate/repo/snapshots/"
)
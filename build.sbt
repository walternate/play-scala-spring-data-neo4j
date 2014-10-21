name := "play-scala-spring-data-neo4j"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers += "Neo4j Maven 2 release repository" at "http://m2.neo4j.org/content/repositories/releases"

resolvers += "SpringSource Milestone Repository" at "http://repo.springsource.org/milestone"

libraryDependencies ++= Seq(
//  jdbc,
//  anorm,
//  cache,
  "org.neo4j" % "neo4j" % "2.1.5",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework" % "spring-context" % "3.2.10.RELEASE",
  "org.springframework.data" % "spring-data-neo4j" % "3.1.4.RELEASE", //3.2.0.RELEASE
  "org.slf4j" % "jul-to-slf4j" % "1.7.7",
  "org.apache.httpcomponents" % "httpcore" % "4.2.1",
  "org.apache.httpcomponents" % "httpclient" % "4.2.1",
  "org.springframework.scala" %% "spring-scala" % "1.0.0.RC1",
  "javax.validation" % "validation-api" % "1.0.0.GA",
  "janino" % "janino" % "2.5.10",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

play.Project.playScalaSettings

net.virtualvoid.sbt.graph.Plugin.graphSettings
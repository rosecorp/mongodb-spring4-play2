name := """mongodb-spring4-play2"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "4.1.5.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.5.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.1.5.RELEASE",
  "org.springframework" % "spring-tx" % "4.1.5.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.5.RELEASE",
  "org.springframework" % "spring-aop" % "4.1.5.RELEASE",
  "org.springframework.cloud" % "spring-cloud-spring-service-connector" % "1.1.1.RELEASE",
  "org.springframework.cloud" % "spring-cloud-cloudfoundry-connector" % "1.1.1.RELEASE",
  "org.springframework.amqp" % "spring-rabbit" % "1.4.3.RELEASE",
  "org.springframework.data" % "spring-data-redis" % "1.4.2.RELEASE",
  "org.mongodb" % "mongo-java-driver" % "2.12.5",
  "org.springframework.data" % "spring-data-mongodb" % "1.6.2.RELEASE",
  "org.springframework" % "spring-test" % "4.1.5.RELEASE" % "test",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

import sbt._
import sbt.Keys._
object Settings {

  val baseSettings = Seq(
    organization := "com.github.j5ik2o",
    scalaVersion := "2.12.8",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:_",
      "-Ywarn-adapted-args",
      "-Ywarn-dead-code",
      "-Ywarn-inaccessible",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused-import",
      "-Xmax-classfile-name", "200"
    ),
    resolvers ++= Seq(
      Resolver.jcenterRepo,
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("releases"),
      "Seasar2 Repository" at "https://maven.seasar.org/maven2",
      Resolver.bintrayRepo("danslapman", "maven"),
      "DynamoDB Local Repository" at "https://s3-us-west-2.amazonaws.com/dynamodb-local/release"
    ),
    libraryDependencies ++= Seq(
//      Hashids.hashids,
//      Sisioh.baseUnits,
//      TypeSafe.config,
//      Slf4J.api,
//      Enumeratum.enumeratum,
//      Logback.classic       % Test,
//      ScalaTest.scalactic   % Test,
//      ScalaTest.scalaTest   % Test,
//      ScalaCheck.scalaCheck % Test
    )
  )
}

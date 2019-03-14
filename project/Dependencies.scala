import sbt._

object Dependencies {

  object Versions {
    val akka                = "2.5.19"
    val akkaHttp            = "10.1.7"
    val circe               = "0.11.1"
    val slick               = "3.2.0"
    val typeSafeConfig      = "1.3.1"
    val hashids             = "1.0.3"
    val slf4J               = "1.7.25"
    val logback             = "1.2.3"
    val scalaTest           = "3.0.5"
    val mySQLConnectorJava  = "5.1.42"
    val scalaTestPlusDB     = "1.0.5"
    val commonsIO           = "2.6"
    val akkaHttpCirce       = "1.25.2"
    val baseUnits           = "0.1.21"
    val pureConfig          = "0.9.0"
    val scalaCheck          = "1.13.5"
    val monocle             = "1.5.0"
    val enumeratum          = "1.5.12"
    val akkaPersistenceDynamoDB = "1.0.0-SNAPSHOT"
  }

  object Hashids {
    val hashids = "org.hashids" % "hashids" % Versions.hashids
  }

  object Sisioh {
    val baseUnits = "org.sisioh" %% "baseunits-scala" % Versions.baseUnits
  }

  object Slf4J {
    val api = "org.slf4j" % "slf4j-api" % Versions.slf4J
  }

  object Logback {
    val classic = "ch.qos.logback" % "logback-classic" % Versions.logback
  }

  object ScalaTest {
    val scalactic = "org.scalactic" %% "scalactic" % Versions.scalaTest
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest
  }

  object TypeSafe {

    val config = "com.typesafe" % "config" % Versions.typeSafeConfig

    object Akka {

      val slf4j            = "com.typesafe.akka" %% "akka-slf4j"              % Versions.akka
      val actor            = "com.typesafe.akka" %% "akka-actor"              % Versions.akka
      val stream           = "com.typesafe.akka" %% "akka-stream"             % Versions.akka
      val cluster          = "com.typesafe.akka" %% "akka-cluster"            % Versions.akka
      val clusterTools     = "com.typesafe.akka" %% "akka-cluster-tools"      % Versions.akka
      val clusterSharding  = "com.typesafe.akka" %% "akka-cluster-sharding"   % Versions.akka
      val streamTestKit    = "com.typesafe.akka" %% "akka-stream-testkit"     % Versions.akka
      val testKit          = "com.typesafe.akka" %% "akka-testkit"            % Versions.akka
      val persistence      = "com.typesafe.akka" %% "akka-persistence"        % Versions.akka
      val http             = "com.typesafe.akka" %% "akka-http"               % Versions.akkaHttp
      val httpTestKit      = "com.typesafe.akka" %% "akka-http-testkit"       % Versions.akkaHttp
      val multiNodeTestKit = "com.typesafe.akka" %% "akka-multi-node-testkit" % Versions.akka

    }

    object Slick {
      val slick         = "com.typesafe.slick" %% "slick"          % Versions.slick
      val slickHikariCP = "com.typesafe.slick" %% "slick-hikaricp" % Versions.slick
    }

  }

  object Circe {
    val core = "io.circe" %% "circe-core" % Versions.circe
    val generic = "io.circe" %% "circe-generic" % Versions.circe
    val parser = "io.circe" %% "circe-parser" % Versions.circe
    val all = Seq(core, generic, parser)
  }

  object MySQL {
    val connectorJava = "mysql" % "mysql-connector-java" % Versions.mySQLConnectorJava
  }

  object Heikoseeberger {
    val akkaHttpCirce = "de.heikoseeberger" %% "akka-http-circe" % Versions.akkaHttpCirce
  }

  object J5ik2o {
    val scalaTestPlusDB = "com.github.j5ik2o" %% "scalatestplus-db" % Versions.scalaTestPlusDB
    val akkPersistenceDynamoDB = "com.github.j5ik2o" %% "akka-persistence-dynamodb" % Versions.akkaPersistenceDynamoDB
  }

  object PureConfig {
    val pureConfig = "com.github.pureconfig" %% "pureconfig" % Versions.pureConfig
  }

  object ScalaCheck {
    val scalaCheck = "org.scalacheck" %% "scalacheck" % Versions.scalaCheck
  }

  object Enumeratum {
    val enumeratum = "com.beachape" %% "enumeratum" % Versions.enumeratum
  }



}

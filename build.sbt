import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "schemaless",
    libraryDependencies += scalaTest % Test,
    scalacOptions ++= "-deprecation" :: "-feature" :: "-unchecked" :: "-Xfatal-warnings" :: "-Ywarn-dead-code" ::
      "-Ywarn-inaccessible" :: "-Ywarn-infer-any" :: "-Xlint" :: "-Ywarn-unused-import" :: Nil
  )
scalafmtOnCompile := true


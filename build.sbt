ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "yugi-inheritance-1"
  )
libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M11" % Test

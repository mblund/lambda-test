
name := "graalvm-scala-lambda"
scalaVersion := "2.13.6"
assembly / assemblyJarName := "graalvm-scala-lambda.jar"
assembly / mainClass := Some("bootstrap")
assembly / assemblyMergeStrategy := AssemblyStrategy.all
Test / fork := true
//
// Test / javaOptions ++= Seq("-agentlib:native-image-agent=config-merge-dir=src/main/resources/META-INF/native-image")

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "requests" % "0.6.9",
  "com.typesafe.play" %% "play-json" % "2.10.0-RC5",
  "org.scalameta" %% "munit" % "0.7.27" % Test
)

scalacOptions ++= Seq(
  "-deprecation",         // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",   // Specify character encoding used by source files.
  "-feature",             // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked",           // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings"      // Fail the compilation if there are any warnings.
)


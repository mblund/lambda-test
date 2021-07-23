
name := "graalvm-scala-lambda"
scalaVersion := "2.13.6"
assembly / assemblyJarName := "graalvm-scala-lambda.jar"
assembly / mainClass := Some("bootstrap")
assembly / assemblyMergeStrategy := AssemblyStrategy.all

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "requests" % "0.6.9",
  "com.typesafe.play" %% "play-json" % "2.10.0-RC5"
)

scalacOptions ++= Seq(
  "-deprecation",         // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",   // Specify character encoding used by source files.
  "-explaintypes",        // Explain type errors in more detail.
  "-feature",             // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked",           // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit",          // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings"      // Fail the compilation if there are any warnings.
)


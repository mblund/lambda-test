import sbtassembly.{MergeStrategy, PathList}

object AssemblyStrategy {

  val all: String => MergeStrategy = {
    case PathList("META-INF", "MANIFEST.MF")                                       => MergeStrategy.discard
    case PathList("org", "apache", xs @ _*)                                        => MergeStrategy.last
    case "module-info.class"                                                       => MergeStrategy.last
    case x                                                                         => MergeStrategy.defaultMergeStrategy(x)
  }
}

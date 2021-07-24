FROM ghcr.io/graalvm/graalvm-ce:latest

WORKDIR /tmp/dist

RUN gu install native-image
CMD native-image -J-Xmx10g -jar /tmp/target/graalvm-scala-lambda.jar --enable-url-protocols=http bootstrap --no-fallback \
  --initialize-at-run-time=scalikejdbc.CommonsConnectionPool --initialize-at-run-time=org.postgresql.sspi.SSPIClient --initialize-at-run-time=scala.tools.reflect.FormatInterpolator --initialize-at-run-time=scala.tools.nsc.typechecker.ContextErrors --initialize-at-run-time=scala.tools.nsc.ast.parser.ParsersCommon "--initialize-at-run-time=scala.tools.nsc.ast.parser.Parsers$Parser" --initialize-at-build-time=org.postgresql.Driver --initialize-at-build-time=org.postgresql.util.SharedTimer \
  -H:+ReportExceptionStackTraces \
  -H:+AllowIncompleteClasspath

#CMD java -agentlib:native-image-agent=config-output-dir=/tmp/dist -jar /tmp/target/graalvm-scala-lambda.jar
#c:\opt\ue>native-image.cmd --initialize-at-run-time=org.simpleflatmapper.util.ParallelReader --initialize-at-run-time=scalikejdbc.CommonsConnectionPool --initialize-at-run-time=org.postgresql.sspi.SSPIClient --initialize-at-run-time=scala.tools.reflect.FormatInterpolator --initialize-at-run-time=scala.tools.nsc.typechecker.ContextErrors --initialize-at-run-time=scala.tools.nsc.ast.parser.ParsersCommon "--initialize-at-run-time=scala.tools.nsc.ast.parser.Parsers$Parser" --initialize-at-build-time=org.postgresql.Driver --initialize-at-build-time=org.postgresql.util.SharedTimer --enable-url-protocols=https -H:ReflectionConfigurationFiles=reflectconfig.json -H:-UseServiceLoaderFeature --allow-incomplete-classpath -cp "jsrc\bp.sc.jar;C:\opt\uejlib\*;\opt\ueolib\*" -H:+ReportExceptionStackTraces Main

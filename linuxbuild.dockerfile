FROM ghcr.io/graalvm/graalvm-ce:latest

WORKDIR /tmp/dist

RUN gu install native-image
CMD native-image -J-Xmx10g -jar /tmp/target/graalvm-scala-lambda.jar --enable-url-protocols=http bootstrap --no-fallback

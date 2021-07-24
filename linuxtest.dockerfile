FROM ghcr.io/graalvm/graalvm-ce:latest

RUN curl -L https://github.com/sbt/sbt/releases/download/v1.5.5/sbt-1.5.5.tgz > sbt.tgz \
    && tar -zxvf sbt.tgz

RUN gu install native-image

WORKDIR /tmp/src

CMD /sbt/bin/sbt test

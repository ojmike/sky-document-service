FROM maven:alpine as build
ARG uid=1001
ARG gid=51
WORKDIR /opt/build

RUN addgroup --gid $gid maven1 && \
    adduser --disabled-password --gecos "" --no-create-home --uid $uid --gid $gid maven1

# Copy the source code to the container
COPY --chown=maven1:maven1 . /home/maven/src
WORKDIR /home/maven/src/document-service
RUN mvn package



FROM amazoncorretto:21-alpine3.16
RUN mkdir /app

RUN rm -f /etc/localtime
RUN ln -s /usr/share/zoneinfo/Africa/Lagos /etc/localtime


COPY --from=build /home/maven/src/document-service/build/libs/*.jar  sky-document-service.jar

ENV JAVA_OPTS='-Xmx17G'

ENTRYPOINT java -XX:+UseZGC "$JAVA_OPTS" sky-document-service.jar



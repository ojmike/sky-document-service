FROM maven:alpine as build

WORKDIR /opt/build

COPY ./sky-document-service /home/mvn/src
WORKDIR /home/maven/src/document-service
RUN mvn package



FROM amazoncorretto:21-alpine3.16
RUN mkdir /app

RUN rm -f /etc/localtime
RUN ln -s /usr/share/zoneinfo/Africa/Lagos /etc/localtime


COPY --from=build /home/maven/src/document-service/build/libs/*.jar  sky-document-service.jar

ENV JAVA_OPTS='-Xmx17G'

ENTRYPOINT java -XX:+UseZGC "$JAVA_OPTS" sky-document-service.jar



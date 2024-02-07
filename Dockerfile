FROM maven:alpine as build

COPY . /home/maven/src
RUN ls -la
WORKDIR /home/maven/src/document-service
RUN ls -la
RUN mvn package



FROM amazoncorretto:21-alpine3.16
RUN mkdir /app

RUN rm -f /etc/localtime
RUN ln -s /usr/share/zoneinfo/Africa/Lagos /etc/localtime


COPY --from=build /home/maven/src/document-service/build/libs/*.jar  sky-document-service.jar

ENV JAVA_OPTS='-Xmx17G'

ENTRYPOINT java -XX:+UseZGC "$JAVA_OPTS" sky-document-service.jar



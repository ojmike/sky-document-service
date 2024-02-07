FROM maven:3.9.6-sapmachine-21 as build

COPY . /home/maven/src
RUN ls -la
WORKDIR /home/maven/src/
RUN ls -la
RUN mvn package -DskipTests



FROM amazoncorretto:21-alpine3.16
RUN mkdir /app

RUN rm -f /etc/localtime
RUN ln -s /usr/share/zoneinfo/Africa/Lagos /etc/localtime


COPY --from=build /home/maven/src/target/*.jar  sky-document-service.jar


ENTRYPOINT java -jar sky-document-service.jar



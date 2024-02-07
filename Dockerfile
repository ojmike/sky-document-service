FROM amazoncorretto:21-alpine3.16
VOLUME /tmp
ARG version=21.0.1.12.1
LABEL authors="Sky Document Service <support@skysystem.com>"
ARG TARGET_ENVIRONMENT
EXPOSE 3400 3400
# Install and setup
ADD target/document-service-0.0.1-SNAPSHOT.jar document-service-0.0.1-SNAPSHOT.jar
# Ensure font config is available for alpine and add fonts used by POI to generate excel report
RUN apk --update add \
    fontconfig \
    ttf-dejavu \
    wget \
    unzip

RUN rm -f /etc/localtime
RUN ln -s /usr/share/zoneinfo/America/Chicago /etc/localtime

ENV JAVA_OPTS='-Xms6G -Xmx6G'

ENTRYPOINT java  -jar -Dspring.profiles.active=docker  -XX:-OmitStackTraceInFastThrow $JAVA_OPTS document-service-0.0.1-SNAPSHOT.jar

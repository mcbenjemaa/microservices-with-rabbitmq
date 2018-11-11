FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8100

ARG JAR_FILE=target/control-service.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

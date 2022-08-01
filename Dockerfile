FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER victornsgr
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} task-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/task-0.0.1.jar"]
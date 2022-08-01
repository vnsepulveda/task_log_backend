FROM openjdk:17-oracle
MAINTAINER victornsgr
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} task-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/task-0.0.1.jar"]
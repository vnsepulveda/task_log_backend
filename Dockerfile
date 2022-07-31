FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER victornsgr
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} task_app_backend_release/0.1.jar
ENTRYPOINT ["java", "-jar", "/task_app_backend_release/0.1.jar"]
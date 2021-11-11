FROM openjdk:17-alpine
RUN echo "lll"
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]

EXPOSE 8080
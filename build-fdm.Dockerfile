FROM gradle:7.3.0-jdk17-alpine

COPY src src
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY build.sh build.sh

ENTRYPOINT ["sh","./build.sh"]
EXPOSE 8080
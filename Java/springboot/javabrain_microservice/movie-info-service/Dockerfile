FROM openjdk:11-jdk-slim

COPY ./build/libs/movie-info-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","movie-info-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082
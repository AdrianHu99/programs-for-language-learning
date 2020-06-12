FROM openjdk:11-jdk-slim

COPY ./build/libs/movie-rating-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","movie-rating-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8083
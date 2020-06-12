FROM openjdk:11-jdk-slim

COPY ./build/libs/discovery-server-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","discovery-server-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761

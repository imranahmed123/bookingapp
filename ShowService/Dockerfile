FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/show-service-0.0.1-SNAPSHOT.jar show-service.jar
ENTRYPOINT ["java","-jar","/show-service.jar"]

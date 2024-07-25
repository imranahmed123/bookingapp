FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/movie-service-0.0.1-SNAPSHOT.jar movie-service.jar
ENTRYPOINT ["java","-jar","/movie-service.jar"]

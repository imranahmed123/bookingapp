FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/admin-service-0.0.1-SNAPSHOT.jar admin-service.jar
ENTRYPOINT ["java","-jar","/admin-service.jar"]

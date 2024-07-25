FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/booking-service-0.0.1-SNAPSHOT.jar booking-service.jar
ENTRYPOINT ["java","-jar","/booking-service.jar"]

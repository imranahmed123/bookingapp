FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/theatre-service-0.0.1-SNAPSHOT.jar theatre-service.jar
COPY src/main/resources/prometheus.yml /etc/prometheus/prometheus.yml
COPY src/main/resources/logstash.conf /usr/share/logstash/pipeline/logstash.conf
ENTRYPOINT ["java","-jar","/theatre-service.jar"]

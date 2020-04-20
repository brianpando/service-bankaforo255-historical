FROM openjdk:13
VOLUME /tmp
EXPOSE 8082
ADD ./target/services-bankaforo255-historical-0.0.1-SNAPSHOT.jar service-historical.jar
ENTRYPOINT ["java","-jar","/service-historical.jar"]
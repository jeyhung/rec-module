FROM openjdk:11-jdk-slim
MAINTAINER jeyhung
COPY target/rec-module-0.0.1.jar app.jar
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar"]
CMD ["/app.jar"]
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/java-microservice-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -Dserver.port=8081 -jar /app.jar

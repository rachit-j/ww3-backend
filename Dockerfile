# syntax=docker/dockerfile:1
FROM openjdk:17
WORKDIR /app
COPY . /app
RUN ./mvnw package
CMD ["java", "-jar", "target/spring-0.0.1-SNAPSHOT.jar"]
EXPOSE 8062

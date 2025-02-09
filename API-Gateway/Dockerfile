FROM gradle:8.2.1-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

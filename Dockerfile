# Builder stage
FROM gradle:8.4-jdk17-alpine AS builder
WORKDIR /app
COPY . .
# Build the application
RUN gradle build --no-daemon

# Final stage
FROM openjdk:17-alpine
WORKDIR /app
# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/elasticsearch-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app/elasticsearch-0.0.1-SNAPSHOT.jar"]

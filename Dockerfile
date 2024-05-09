# Use a base image with Java 17 pre-installed
FROM adoptopenjdk/openjdk17:alpine-jre AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ ./gradle

# Copy the source code
COPY src ./src

# Build the project
RUN ./gradlew build -x test

# Use another base image for the final image
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage into the container
COPY --from=builder /app/build/libs/your-application.jar ./app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]

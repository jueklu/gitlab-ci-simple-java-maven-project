### Stage 1: Build Stage

# Use a lightweight JRE image as the base image / define as build stage
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set the working directory inside the build stage
WORKDIR /app

# Copy the Maven project files into the container
COPY HelloMaven-app/pom.xml ./
COPY HelloMaven-app/src ./src

# Build the application with dependencies included
RUN mvn clean compile assembly:single



### Stage 2: Runtime Stage

# Use a lightweight JRE image as the base image
FROM eclipse-temurin:17-jre-alpine

# Create a user & group
RUN addgroup -S app-group && adduser -S app-user -G app-group

# Set the working directory inside the runtime stage
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime stage
COPY --from=build /app/target/HelloMaven-app-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Change ownership of the application files
RUN chown -R app-user:app-group /app

# Switch to the non-root user
USER app-user

# Expose port 80 for the web server
EXPOSE 80

# Command to run the application
ENTRYPOINT ["sh", "-c", "java -jar app.jar && tail -f /dev/null"]

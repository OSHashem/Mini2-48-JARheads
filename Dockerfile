
# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-slim


# Set the working directory inside the container
WORKDIR /app

# Copy only the built JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar


# Set environment variables
ENV INSTANCE="Instance 1"




# Expose port 8080 for the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

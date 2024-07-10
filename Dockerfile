# Use an official OpenJDK runtime as a parent image
FROM openjdk:18-jdk-slim

# Set the working directory in the container
WORKDIR /app


# Copy the application's jar file into the container at /app
COPY target/shopping-list-0.0.1-SNAPSHOT.jar /app/shopping-list.jar


# Run the jar file
ENTRYPOINT ["java", "-jar", "shopping-list.jar"]

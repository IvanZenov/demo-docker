# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .

# Download and install Maven dependencies
RUN mvn clean install -DskipTests

# Copy the application source code
COPY src ./src

# Build the JAR file
RUN mvn clean install spring-boot:repackage -DskipTests

# Create a new image with the JRE
FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage to the final image
COPY --from=build /app/target/*.jar app.jar

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]

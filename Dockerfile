# Use a base image with Java installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Java classes from the bin directory to the container
COPY bin/ ./

# Specify the command to run your application
CMD ["java", "com.simulator.Main"]
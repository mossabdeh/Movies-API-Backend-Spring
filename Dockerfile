# Use the official OpenJDK base image with Maven to build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY ./ ./
RUN mvn clean install -DskipTests

# Use a lightweight base image to run the application
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/movies-api-backend.jar ./

# Set the server port (8082 by default)
EXPOSE 8082

# Command to run the application
CMD ["java", "-jar", "movies-api-backend.jar"]


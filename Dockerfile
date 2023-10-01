# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk17:alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the defined working directory
COPY target/movies-api-backend-0.0.1-SNAPSHOT.jar /app/movies-api-backend.jar

# Expose the port your application will run on
EXPOSE 8082

# Set environment variables for MongoDB configuration
ENV SERVER_PORT=8082
ENV SPRING_DATA_MONGODB_DATABASE=${MONGO_DATABASE}
ENV SPRING_DATA_MONGODB_URI=mongodb+srv://${MONGO_USER}:${MONGO_PASSWORD}@${MONGO_CLUSTER}

# Define the command to run your application
CMD ["java", "-jar", "movies-api-backend.jar"]

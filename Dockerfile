FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy the Gradle files first to leverage Docker caching
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src src

# Grant execute permission for gradlew and build the application
RUN chmod +x ./gradlew && ./gradlew build -x test

# Use a smaller runtime image
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# ===== Build Stage =====
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy source code
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# ===== Run Stage =====
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built jar from previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

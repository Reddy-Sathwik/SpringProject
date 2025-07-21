# ===== Build Stage =====
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom and source files
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Build and package the app
RUN mvn clean package -DskipTests

# ===== Run Stage =====
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

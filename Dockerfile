# Stage 1: Build the application
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/Hospital_Management_System.jar Hospital_Management_System.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "Hospital_Management_System.jar"]

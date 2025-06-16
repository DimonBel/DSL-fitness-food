# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy Maven files from backend-dsl directory
COPY backend-dsl/pom.xml .
RUN mvn dependency:go-offline

# Copy source code from backend-dsl directory
COPY backend-dsl/src ./src
COPY backend-dsl/checkstyle-suppressions.xml .
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar application.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
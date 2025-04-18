# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app
# Create dependency cache layer
COPY pom.xml .
RUN mkdir -p /root/.m2 && \
    mvn dependency:go-offline -B

# Build application
COPY src ./src
RUN mvn package -DskipTests


# ---- Run Stage ----
FROM azul/zulu-openjdk-alpine:21

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
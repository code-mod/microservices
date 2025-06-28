# Stage 1: build the application
FROM maven:3.8.7-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2: run the application
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/quarkus-app/lib/ /app/lib/
COPY --from=build /app/target/quarkus-app/*.jar /app/
COPY --from=build /app/target/quarkus-app/app/ /app/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /app/quarkus/
ENTRYPOINT ["java", "-jar", "/app/*-runner.jar"]

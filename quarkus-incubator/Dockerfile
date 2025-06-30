<<<<<<< HEAD
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
=======
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /incubator
COPY pom.xml .
COPY src ./src
RUN mavn clean compile package -DskipTests


FROM eclipse-temurin:21-jre-alpine-3.21
WORKDIR /incubator
COPY --from=build /incubator/target/quarkus-app/lib /app/lib
COPY --from=build /incubator/target/quarkus-app/ /app/quarkus
COPY --from=build /incubator/target/quarkus-app/app/ /app/app
COPY --from=build /incubator/target/quarkus-app/quarkus-run.jar /app/

EXPOSE 8180

CMD ["java" , "-XX:+UseContainerSupport", "-jar", "quarkus-run.jar"]
>>>>>>> 77600456a06bcfb8eec85d11c413c548fa0d3dcc

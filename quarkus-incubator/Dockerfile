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
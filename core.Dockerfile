FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY event-handler/pom.xml event-handler/
COPY common/pom.xml common/
COPY core-service/pom.xml core-service/
COPY suppressions.xml .
RUN mvn dependency:go-offline
COPY event-handler/src event-handler/src
COPY common/src common/src
COPY core-service/src core-service/src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/core-service/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
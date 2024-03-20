FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY event-handler/ event-handler/
COPY common/ common/
COPY core-service/ core-service/
COPY suppressions.xml .
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/event-handler/target/*.jar application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "application.jar"]
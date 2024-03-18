FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY core-service/ core-service/
COPY common/ common/
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/core-service/target/*.jar application.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "application.jar"]
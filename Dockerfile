FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .

COPY . .

RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /build/target/employee-management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]



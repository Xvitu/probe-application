FROM maven:3.8-openjdk-17-slim AS builder

COPY src /app/src
COPY pom.xml /app

RUN mvn install -f /app/pom.xml clean package -DskipTests


FROM openjdk:17-slim

WORKDIR /app

COPY /target/sonda.candidato-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/sonda.candidato-0.0.1-SNAPSHOT.jar", "-Dspring.profiles.active=default", "-Duser.Timezone=America/Sao_Paulo"]


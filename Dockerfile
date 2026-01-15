FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY testng.xml .

# Pre-download dependencies to speed up subsequent builds
RUN mvn dependency:go-offline

ENTRYPOINT ["mvn", "clean", "test"]

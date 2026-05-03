FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/usercard-0.0.1-SNAPSHOT.jar /app/usercard.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "usercard.jar"]
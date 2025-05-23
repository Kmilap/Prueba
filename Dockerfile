FROM openjdk:17
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "target/QUIZCAMILA-1.jar"]

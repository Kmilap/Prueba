FROM openjdk:17
COPY "/target/QUIZCAMILA-1.jar" "app.jar"
EXPOSE 8765
ENTRYPOINT [ "java", "-jar", "app.jar" ]

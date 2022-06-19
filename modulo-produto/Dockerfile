FROM openjdk:8-alpine
COPY ./target/modulo-produto-0.0.1-SNAPSHOT.jar /app/modulo-produto-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "modulo-produto-0.0.1-SNAPSHOT.jar"]
EXPOSE 9090
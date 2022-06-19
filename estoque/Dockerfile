FROM openjdk:8-alpine
COPY ./target/estoque-0.0.1-SNAPSHOT.jar /app/estoque-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "estoque-0.0.1-SNAPSHOT.jar"]
EXPOSE 9091
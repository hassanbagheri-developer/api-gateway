FROM eclipse-temurin:21-jdk
EXPOSE 8080
COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.yml application.yml
ENTRYPOINT ["java","-jar","/api-gateway-0.0.1-SNAPSHOT.jar"]


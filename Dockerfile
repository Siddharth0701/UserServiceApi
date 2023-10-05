FROM eclipse-temurin:17
LABEL mentainer="siddharth.singh0701@gmail.com"
WORKDIR /app
COPY target/UserService-0.0.1-SNAPSHOT.jar /app/UserService.jar
ENTRYPOINT ["java", "-jar", "UserService.jar"]
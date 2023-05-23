FROM openjdk:17-jdk-slim
COPY build/libs/comment-service-0.0.1-SNAPSHOT.jar comment-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/comment-service.jar"]

FROM openjdk:8u212-b04-jdk-slim
EXPOSE 8080
EXPOSE 8778
ADD @project.artifactId@-@project.version@.jar /app.jar
CMD ["java", "-jar", "app.jar"]
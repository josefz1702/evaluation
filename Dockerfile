FROM openjdk:8
ADD sample-project-0.0.1-SNAPSHOT.jar sample-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","sample-project-0.0.1-SNAPSHOT.jar"]
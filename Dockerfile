FROM openjdk:17
ADD app/build/libs/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar
ADD domain/build/libs/domain-1.0-SNAPSHOT.jar domain-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]
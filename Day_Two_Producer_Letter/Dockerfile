FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
#RUN apk add maven
#RUN mvn clean install
ARG JAR_FILE=target/Day_Two_Producer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

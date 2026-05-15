FROM amazoncorretto:17-alpine-jdk
MAINTAINER Nikit
COPY target/Login_Service-0.0.1-SNAPSHOT.jar Login_Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Login_Service-0.0.1-SNAPSHOT.jar"]

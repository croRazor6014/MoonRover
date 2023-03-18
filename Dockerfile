FROM amazoncorretto:17-alpine-jdk
MAINTAINER baeldung.com
COPY target/docker-moonrover-1.0.0.jar moonrover-1.0.0.jar
ENTRYPOINT ["java","-jar","/moonrover-1.0.0.jar"]
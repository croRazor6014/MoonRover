FROM amazoncorretto:17-alpine-jdk
COPY target/moonrover-1.0.0.jar moonrover-1.0.0.jar
ENTRYPOINT ["java","-jar","/moonrover-1.0.0.jar"]
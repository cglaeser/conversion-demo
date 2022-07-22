# build
FROM maven:3.6.2-jdk-11 AS build
COPY . .
RUN mvn package -DskipTests


FROM openjdk:18.0.1-jdk AS jar-executor
MAINTAINER Christian Glaeser <glaeser@7says.de>
VOLUME /tmp
COPY --from=build /target/conversion-backend.jar conversion-backend.jar
ENTRYPOINT ["java","-jar","conversion-backend.jar"]
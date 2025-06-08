# Build stage
FROM maven:3.8.3-openjdk-17 AS build
LABEL COMPANY="cvt"
LABEL MAINTAINER="kelvinmaxwell@gmail.com"
LABEL APPLICATION="cvt"

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean package -DskipTests

# Final stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage to the working directory
COPY --from=build /usr/src/app/target/cvtgateway-springboot-images.jar /app/cvtgateway.jar

EXPOSE 8080

# Set environment variable to disable APR
ENV JAVA_OPTS="-Dserver.tomcat.apr-lifecycle-listener.enabled=false"

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/cvtgateway.jar"]

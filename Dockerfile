# For java 8 use below base image
FROM openjdk:8-jdk-alpine

# Install git to clone to repo
RUN sudo apt-get -y update && apt-get -y upgrade && apt-get -y install git

# install maven
RUN sudo apt-get -y update && apt-get -y install maven

# Change working directory to /opt/app
WORKDIR /opt/app

# Copy application jar to /opt/app/app.jar
ARG JAR_FILE=target/task-management-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the jar file with ENTRYPOINT
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

# For java 8 use below base image
FROM openjdk:8-jdk-alpine

# Install git to clone to repo
RUN sudo apt-get -y update && apt-get -y upgrade && apt-get -y install git

# install maven
RUN sudo apt-get -y update && apt-get -y install maven

#Now clone repository from github (created task-management-app application for docker 201)
RUN git clone https://github.com/NSrilalitha/task-management.git

# Now run maven clean install command to generate jar file for the application
RUN mvn clean install -Dmaven.test.skip=true

# Copy application jar to /opt/app/app.jar
ARG JAR_FILE=target/task-management-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose port as endpoint
ENDPOINT 8080

# Run the jar file with ENTRYPOINT
# now run java -jar task-management-app-0.0.1-SNAPSHOT.jar command to start the application
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]

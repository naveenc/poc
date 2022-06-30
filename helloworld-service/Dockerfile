FROM  openjdk:11
ARG JAR_FILE=target/*.jar

# Make port 8098 available to the world outside this container
EXPOSE 8098

WORKDIR /work

# Add the application's jar to the container
COPY ${JAR_FILE} /work/app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar","/work/app.jar"]
FROM java:alpine
EXPOSE 5000
WORKDIR /opt/app
ADD ./target/geocoding-task-0.1.jar /opt/app
CMD ["java", "-jar", "./geocoding-task-0.1.jar"]

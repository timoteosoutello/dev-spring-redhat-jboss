## Brief Description

This API it's a just a sample use for spring boot + spring data + spring data rest + spring actuator + swagger with java 11 version in the JBOSS/Wildfly server.

## Configure environment
1-) Setup

1.1-) Installing Java 11
Download JDK on http://www.oracle.com/technetwork/java/javase/downloads

Set JAVA_HOME env based on where the JDK will be installed. Add to PATH as JAVA_HOME\bin. 

To know if the java is installed, run "java -version" command on prompt should work 

1.2-) Installing Maven
Download the latest version on https://maven.apache.org/download.cgi

Define the variable MVN_HOME on your OS pointing to the extracted directory. Add to the PATH variable the MVN_HOME\bin.

To know if the mvn is installed, run the command "mvn --version" and check if its recognition by the SO or not;

1.3-) Installing database

Depends on what to be used, need to change the pom dependency and other datasource parameters like below:

Without JBOSS:
spring.datasource.url=jdbc:
spring.datasource.driver-class-name=
PS: Currently using H2 memory database

With JBOSS, is necessary to adapt the standalone/domain configurations.


## Running the App

**1-) Via Maven**
mvn spring-boot:run

**2-) Via Docker**

**Building up**:

docker build --no-cache -t spring-backend-jboss .

docker run -d --restart always -p 8080:8080 --name spring-backend-jboss -t spring-backend-jboss

**Publishing (with tag version)**:

docker build --no-cache -t tsoutello/spring-backend-jboss:1.0.0 --tag tsoutello/spring-backend-jboss:1.0.0 .

docker push tsoutello/spring-backend-jboss:1.0.0

**Killing the container**:

docker container kill spring-backend-jboss

docker container prune

**Using Docker Swarm / Docker Compose**

docker stack deploy --prune --compose-file docker-compose.yml spring-backend


## Accessing application by swagger-UI

- App: http://localhost:8080/spring-jboss  
- Swagger: http://localhost:8080/spring-jboss/swagger-ui.html
- curl localhost:8080/spring-jboss/actuator/health

## External References

- https://infinispan.org/
- http://www.mastertheboss.com/jboss-frameworks/infinispan/using-infinispan-with-wildfly-8
- https://infinispan.org/tutorials/simple/hibernate-cache-spring-local/
- https://github.com/infinispan/infinispan-simple-tutorials/tree/master/hibernate-cache
- https://medium.com/@skywalkerhunter/speeding-up-your-hibernate-with-cache-level-2-ehcache-in-1-min-28255622bf6f

# This official image uses OpenJDK 11 and Wildfly 18
FROM jboss/wildfly:21.0.0.Final

# Copy the war file to the deployments folder
COPY target/spring-jboss \
     /opt/jboss/wildfly/standalone/deployments

# This official image uses OpenJDK 11 and Wildfly 21
FROM jboss/wildfly:21.0.0.Final

# Copy the war file to the deployments folder
COPY target/spring-jboss.war \
     /opt/jboss/wildfly/standalone/deployments

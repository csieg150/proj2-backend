# we are extending everything from tomcat:9.0 image ...
FROM tomcat:9.0
MAINTAINER Siegfried
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY ./target/project.war /usr/local/tomcat/webapps/
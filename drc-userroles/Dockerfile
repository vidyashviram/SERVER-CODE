# Using official python runtime base image
FROM openjdk:8-alpine

LABEL maintainer="bushrafathima2020"

# HTTP and HTTPS Proxy settings
ENV http_proxy 'http://10.9.53.7:8080'
ENV https_proxy 'http://10.9.53.7:8080'


RUN apk update && apk upgrade

# Set the application directory

WORKDIR /drc-userroles
RUN wget http://10.9.41.242:8081/repository/mro-drc-services/com/mro/drc/drc-userroles/1.0/drc-userroles-1.0.jar


# Make port 8085 available for links and/or publish
EXPOSE 8085


ENTRYPOINT ["java", "-jar", "drc-userroles-1.0.jar"]

# Using official python runtime base image
FROM openjdk:8-alpine

LABEL maintainer="bushrafathima2020"

# HTTP and HTTPS Proxy settings
ENV http_proxy 'http://10.9.53.7:8080'
ENV https_proxy 'http://10.9.53.7:8080'


RUN apk update && apk upgrade

# Set the application directory

WORKDIR /drc-administrator
RUN wget http://10.9.41.242:8081/repository/mro-drc-services/com/mro/drc/drc-administrator/1.0/drc-administrator-1.0.jar


# Make port 8086 available for links and/or publish
EXPOSE 8086


ENTRYPOINT ["java", "-jar", "drc-administrator-1.0.jar"]

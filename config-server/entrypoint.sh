#!/bin/sh
while ! nc -z  eureka-server 9093 ; do
    echo "Waiting for the  Eureka Server"
    sleep 3
done

java -jar /opt/config-server-0.0.1-SNAPSHOT.jar
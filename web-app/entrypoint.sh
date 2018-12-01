#!/bin/sh
while ! nc -z config-server 9090 ; do
    echo "Waiting for the Config Server"
    sleep 3
done

java -jar /opt/web-app-0.0.1-SNAPSHOT.jar
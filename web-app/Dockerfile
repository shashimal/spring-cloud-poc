FROM maven:3.6.0-jdk-8

RUN apt-get update
RUN apt-get install netcat --assume-yes

WORKDIR /app

COPY ./web-app/pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./web-app/ /app

RUN mvn -v
RUN mvn clean install -DskipTests

RUN cp ./target/web-app-0.0.1-SNAPSHOT.jar /opt
RUN cp ./entrypoint.sh /opt
RUN chmod 755 /opt/entrypoint.sh

EXPOSE 9091

LABEL maintainer=“shashimald@gmail.com”
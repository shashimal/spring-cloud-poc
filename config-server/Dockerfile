FROM maven:3.6.0-jdk-8

RUN apt-get update
RUN apt-get install netcat --assume-yes

WORKDIR /app

COPY ./config-server/pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./config-server/ /app

RUN mvn -v
RUN mvn clean install -DskipTests

EXPOSE 9090
LABEL maintainer=“shashimald@gmail.com”

RUN cp ./target/config-server-0.0.1-SNAPSHOT.jar /opt
RUN cp ./entrypoint.sh /opt
RUN chmod 755 /opt/entrypoint.sh
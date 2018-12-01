FROM maven:3.6.0-jdk-8

RUN apt-get update
RUN apt-get install netcat --assume-yes

WORKDIR /app

COPY ./product-service/pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./product-service/ /app

RUN mvn -v
RUN mvn clean install -DskipTests

RUN cp ./target/product-service-0.0.1-SNAPSHOT.jar /opt
RUN cp ./entrypoint.sh /opt
RUN chmod 755 /opt/entrypoint.sh

EXPOSE 9092

LABEL maintainer=“shashimald@gmail.com”
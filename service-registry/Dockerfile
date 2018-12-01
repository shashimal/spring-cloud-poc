FROM maven:3.6.0-jdk-8

RUN apt-get update
RUN apt-get install netcat --assume-yes

WORKDIR /app

COPY ./service-registry/pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./service-registry/ /app

RUN mvn -v
RUN mvn clean install -DskipTests

RUN cp ./target/service-registry-0.0.1-SNAPSHOT.jar service-registry-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","service-registry-0.0.1-SNAPSHOT.jar"]
EXPOSE 9093

LABEL maintainer=“shashimald@gmail.com”
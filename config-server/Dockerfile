FROM maven:3.6.0-jdk-8

WORKDIR /app

COPY ./config-server/pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./config-server/ /app

RUN mvn -v
RUN mvn clean install -DskipTests

EXPOSE 9090
LABEL maintainer=“shashimald@gmail.com”
RUN cp ./target/config-server-0.0.1-SNAPSHOT.jar config-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]
FROM maven:3.6-jdk-11 as maven_build
WORKDIR /app
COPY . .
RUN mvn clean install
COPY target/userandtransaction-0.0.1-SNAPSHOT.jar userandtransaction-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/userandtransaction-0.0.1-SNAPSHOT.jar"]
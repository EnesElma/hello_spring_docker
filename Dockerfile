#
# maven build ile container içinde jar dosyası oluşturma
#
FROM maven:3.8-openjdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# üstte oluşturulan jar dosyasını imaj haline getirme
#
FROM openjdk:8-jre-slim-buster
COPY --from=build /home/app/target/hello_spring_docker.jar /home/app/hello_spring_docker.jar
WORKDIR /home/app/
CMD java -jar hello_spring_docker.jar


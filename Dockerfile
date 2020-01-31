FROM openjdk:11.0-slim

COPY ./build/libs/rpgd-api-0.1.0.jar /rpgd-api-0.1.0.jar

EXPOSE 8080
CMD java \
    -Dspring.datasource.username=$DB_USER \
    -Dspring.datasource.password=$DB_PASSWORD \
    -Dspring.datasource.url=$DB_CONNECTION_STRING \
    -Djava.security.egd=file:/dev/./urandom \
    -jar /rpgd-api-0.1.0.jar

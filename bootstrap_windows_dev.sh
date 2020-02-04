#!/bin/bash

docker network create rpgd-net
docker-compose up -d rpgd-db
docker exec -it rpgd-db-dev createdb -U postgres rpgd-dev
docker-compose down
./gradlew bootJar
docker-compose build
docker-compose up -d

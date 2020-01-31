#!/bin/bash

docker network create rpgd-net
docker-compose up -d rpgd-db
docker exec -it rpgd-db-dev createdb -U postgres rpgd-dev
docker-compose down
make build-jar
make docker-build
make docker-up

# This should probably be converted to a Gradle task.

build-jar:
	./gradlew bootJar

docker-build:
	docker-compose build

docker-up:
	docker-compose up -d

test:
	gradle cleanTest test integration

rebuild: build-jar docker-build docker-up

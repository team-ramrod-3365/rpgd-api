# rpgd-api
RPG Data as a Service is a RESTful API that allows users to store and manipulate data for role playing games.

## Dependencies
- Linux
  - OpenJDK 11.0.6.j9
  - Docker
- Mac OS X
  - Xcode
  - Brew
  - OpenJDK 11.0.6.j9
  - Docker
- Windows
  - OpenJDK 11.0.6.j9
  - Docker Toolbox or Docker for Windows
  - Git

## Dev Environment
Once you have Docker and OpenJDK installed run the command `bash bootstrap_dev.sh` to setup your dev environment. After that has finished running, you can run make docker-up to start the application in the foreground or `docker-compose up -d` to run it in the background. You can see all running Docker containers with the comand `docker ps`.

If you would prefer not to run the application in Docker you will still need a local PostgreSQL database. The application is configured to use the following environment variables to connect to the database, and they will need to be set in order for it to run properly: `DB_CONNECTION_STRING`, `DB_USER`, and `DB_PASSWORD`.

Here is an example of how you would set this in a Linux or Mac OS X environment.
```
export DB_CONNECTION_STRING=jdbc:postgresql://localhost:5432/rpgd-dev
export DB_USER=<username>
export DB_PASSWORD=<password>
```

If you are using an IDE to run your application, you will need to set these environment variables in your IDE.

### Windows Docker Toolbox
If you are using Docker Toolbox on Windows there are a few gotchas we've ran into.
- You will need to run the commands from a network that isn't the TTU network in order to download the Java 11 and PostgreSQL images.
- In Docker Toolbox, localhost is 192.168.99.100, so to test you will need to make all HTTP requests to `http://192.168.99.100:8080`.

### Windows Command Line
If you are using an edition of Windows 10 that can run Docker without using Docker Toolbox, such as Windows 10 Pro, you will not be able to use the `bootstrap_windows_dev.sh` bash script without installing the Linux subsystem for Windows. Instead, you will need to run every command in the bootstrap script manually, and you will need to replace `./gradlew bootJar` with `./gradlew.bat bootJar`.

## Contributing
Please follow the [AngularJS commit guidelines](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits) when committing code to the project.

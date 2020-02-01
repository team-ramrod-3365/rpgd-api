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
  - Good luck?

## Dev Environment
Once you have Docker and OpenJDK installed run the command `bash bootstrap_dev.sh` to setup your dev environment. After that has finished running, you can run make docker-up to start the application in the foreground or `docker-compose up -d` to run it in the background. You can see all running Docker containers with the comand `docker ps`.

If you would prefer not to run the application in Docker you will still need a local PostgreSQL database. The application is configured to use the following environment variables to connect to the database, and they will need to be set in order for it to run properly: `DB_CONNECTION_STRING`, `DB_USER`, and `DB_PASSWORD`.

Here is an example of how you would set this in a Linux or Mac OS X environment.
```
export DB_CONNECTION_STRING=jdbc:postgresql://localhost:5432/rpgd-dev
export DB_USER=<username>
export DB_PASSWORD=<password>
```

If you are using an IDE to run your application, you will need to set these environment variables in your IDE. If you are using Windows, you should probably just use the IDE, and may the odds be forever in your favor.

## Contributing
Please follow the [AngularJS commit guidelines](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits) when committing code to the project.

All code changes need to be made on a separate branch following a naming convention of `CS3365-<summary-of-changes>`. In order to create a branch, use the following command:
```
git checkout -b CS3365-<summary-of-changes>
```

You can push these changes to GitHub with these commands:
```
git add .
git commit -am "<change-type>(<thing-changed>): <brief summary of changes>"
git push -u origin CS3365-<summary-of-changes>
```

Once you have pushed once with the arguments `-u origin CS3365-<summary-of-changes>`, you can just use `git push` from that point forward.

All code changes must go through a pull request process with at least one approver from the team. Written code must be tested, even if the tests are sparse.

In order to run the tests, use the command `make test` if on Linux or Mac OS X, or `./gradlew.bat cleanTest test` if on Windows.

# easi_api_java
Experimenting with a new Java GraphQL API

Dev Env Setup

```
brew install java
// Java is cask only, so you gotta symlink it yourself
sudo ln -sfn /usr/local/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
java -version //should return a version number
brew install gradle
brew install --cask graphql-playground
./gradlew bootRun
```
Open GraphQL Playground and use "http://localhost:8080/graphql" as the URL

Database setup
Yes, there are passwords committed in this repo. No, you shouldn't do this for anything deployed to prod. This is a sample project and not meant to ever be a production app.

```
psql postgres
create user java_test_user;
alter user java_test_user with encrypted password 'password';
create database easi_api_java;
grant all privileges on database easi_api_java to java_test_user;
```
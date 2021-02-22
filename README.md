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
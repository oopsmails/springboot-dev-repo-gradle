# java-gradle-start

- References:

https://www.jetbrains.com/help/idea/getting-started-with-gradle.html#run_gradle

Thanks!


## Run Gradle build

- intellij, springboot-dev-repo-gradle

Tasks, build, build

- command line

$ ./gradlew build && ./gradlew :application:bootRun


./gradlew build && ./gradlew :spring-boot-mock-backend:bootRun

$ ./mvnw install && ./mvnw spring-boot:run -pl application

## Learning Gradle

- Ref:
  https://tomgregory.com/gradle-evaluation-order-for-multi-project-builds/

### Adding sub-projects to a Gradle project

Edit the settings.gradle file in the project root directory. 

```
rootProject.name = 'springboot-dev-repo-gradle'
include 'spring-boot-java-main'
include 'spring-boot-mock-backend'
include 'spring-boot-kafka-microservice-email'
include 'java-gradle-start' <--------------------------------- here
```
This is in fact all that is required. Note that:

there’s no need for a separate directory
there’s no need for a separate build.gradle build file
You can now run ./gradlew projects to show that the new sub-projects have been added:







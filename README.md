# springboot-dev-repo-gradle

- References:

https://spring.io/guides/gs/multi-module/

Thanks!


## Run Gradle build

- intellij, springboot-dev-repo-gradle

Tasks, build, build

- command line

$ ./gradlew build && ./gradlew :application:bootRun


./gradlew build && ./gradlew :spring-boot-mock-backend:bootRun

$ ./mvnw install && ./mvnw spring-boot:run -pl application

### 20220711, springboot-dev-repo-gradle, missing spring-boot-java-main

- though in settings.gradle defined, still error ...

```
include 'spring-boot-java-main'
```

- Need to build _spring-boot-java-main_ first, Tasks, publishing, publishToMavenLocal, then, build springboot-dev-repo-gradle

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
```
This is in fact all that is required. Note that:

there’s no need for a separate directory
there’s no need for a separate build.gradle build file
You can now run ./gradlew projects to show that the new sub-projects have been added:







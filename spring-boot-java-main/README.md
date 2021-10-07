# spring-boot-java-main


## Run Gradle build

```
publishing {
  publications {
      mavenJava(MavenPublication) {
          from components.java
      }
  }
  repositories {
    maven {
      credentials {
        username 'admin'
        password 'password'
      }
      url "http://baseUrl/artifactory/libs-release-local"
    }
  }
}

I was having same issue until I added a local repository ~/.m2/repository as follows: repositories { maven { url 'file://' + System.getProperty('user.home') + '/.m2/repository/' } } 

```





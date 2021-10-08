# spring-boot-java-main

- Refs:

https://www.jetbrains.com/help/idea/add-a-gradle-library-to-the-maven-repository.html#publish_remote



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

I was having same issue until I added a local repository ~/.m2/repository as follows: 
repositories { 
    maven { 
        url 'file://' + System.getProperty('user.home') + '/.m2/repository/' 
    }
} 

```


- Publish to remote repo

```
In the build.gradle file add the following section:

publishing {
    publications {
    }
    repositories {
        maven {
            name = "MyRepo" //  optional target repository name
            url = "http://my.org.server/repo/url"
            credentials {
                username = 'alice'
                password = 'my-password'
            }
        }
    }
}

```




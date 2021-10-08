# spring-boot-java-main

- Refs:

https://www.jetbrains.com/help/idea/add-a-gradle-library-to-the-maven-repository.html#publish_remote

https://stackoverflow.com/questions/35876158/can-i-add-a-custom-repository-to-gradle-properties

https://tomgregory.com/gradle-project-properties-best-practices/


## Run Gradle build

### maven install in gradle

- put mavenLocal in build.gradle
- put `publishing`, and run "publishToMavenLocal" in intellij Gradle window

### About custom location of mave repo

20211008: with gradle 7.1

- define mavenLocal url in build.gradle is NO use!
- gradle actually reads settings.xml, in /Users/<user>/.m2. Thus, changing `<localRepository>`


### Some code examples below, kind of useful

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
- another example:

```
You can use somenthing like this:

maven {
credentials {
username getCredentialsMavenUsername()
password getCredentialsMavenPassword()
}
url 'xxxxx'
}

/**
* Returns the credential username used by Maven repository
* Set this value in your ~/.gradle/gradle.properties with CREDENTIALS_USERNAME key
* @return
  */
  def getCredentialsMavenUsername() {
  return hasProperty('CREDENTIALS_USERNAME') ? CREDENTIALS_USERNAME : ""
  }

/**
* Returns the credential password used by Maven repository
* Set this value in your ~/.gradle/gradle.properties with CREDENTIALS_PASSWORD key
* @return
  */
  def getCredentialsMavenPassword() {
  return hasProperty('CREDENTIALS_PASSWORD') ? CREDENTIALS_PASSWORD : ""
  }
  If the user hasn't the credentials the script doesn't fail.

```

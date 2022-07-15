

- useful docker commands

```
albert@eosvm:~/Documents/github/springboot-dev-repo-gradle/spring-boot-kafka-microservice-email-files$ docker-compose up

albert@eosvm:~/Documents/github/springboot-dev-repo-gradle/spring-boot-kafka-microservice-email-files$ docker-compose down

albert@eosvm:~/Documents/github/springboot-dev-repo-gradle/spring-boot-kafka-microservice-email-files$ docker-compose start

albert@eosvm:~/Documents/github/springboot-dev-repo-gradle/spring-boot-kafka-microservice-email-files$ docker-compose stop

docker ps -a

docker volume list

docker volume prune

```

- ERROR: Pool overlaps with other one on this address space

That error suggest a conflict. You could list the network docker network ls and delete the existing one should you find it docker network rm my_network

- spring-boot-kafka-microservice-email_1  | [ERROR] No plugin found for prefix 'spring-boot' in the current project and in the plugin groups [org.apache.maven.plugins, org.codehaus.mojo] available from the repositories [local (/home/deploy/.m2/repository), central (https://repo.maven.apache.org/maven2)] -> [Help 1]
  spring-boot-kafka-microservice-email_1  | [ERROR] 

This error is from the mis-configuration of docker-compose, Deocker

Basically, 

```
# error
volumes:
  - ./configuration:/home/albert/dockerdata/configuration:delegated
  - ../spring-boot-kafka-microservice-email:/home/albert/dockerdata/app:delegated
  - ~/.m2:/home/albert/dockerdata/.m2:cached
  
# correct
volumes:
  - ./configuration:/tmp/configuration:delegated
  - ../spring-boot-kafka-microservice-email:/tmp/app:delegated
  - ~/.m2:/home/deploy/.m2:cached

```
-- concept error: right side of colon is from docker container, i.e, cannot use albert, etc.

- More on docker-compose and configurations

-- the **deploy** user is defined in Dockerfile

-- nginx.conf is point to Spring application

```
        location /messaging {
            set $upstream spring-boot-kafka-microservice-email;
            set $contextpath /messaging;
```

-- restructured need to be taken care





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

- Kafka + Admin UI (Kafdrop) for Local Development with Docker Compose

https://luisdiasdev.medium.com/kafka-kafdrop-for-local-development-with-docker-compose-f2b00a6dda8

```
version: '3'

services:
  zookeeper:
    image: bitnami/zookeeper:3-debian-10
    ports:
      - 2181:2181
    volumes:
      - zookeeper_data:/bitnami
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes

  kafka:
    image: bitnami/kafka:2-debian-10
    ports:
      - 9092:9092
    volumes:
      - kafka_data:/bitnami
    environment:
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
    depends_on:
      - zookeeper

  kafdrop:
    image: obsidiandynamics/kafdrop
    ports:
      - 9100:9000
    environment:
      - KAFKA_BROKERCONNECT=kafka:9092
      - JVM_OPTS=-Xms32M -Xmx64M
    depends_on:
      - kafka

volumes:
  zookeeper_data:
  kafka_data
```


- ERROR: Pool overlaps with other one on this address space

That error suggest a conflict. You could list the network docker network ls and delete the existing one should you find it docker network rm my_network

- spring-boot-kafka-microservice-email_1  | [ERROR] No plugin found for prefix 'spring-boot' in the current project and in the plugin groups [org.apache.maven.plugins, org.codehaus.mojo] available from the repositories [local (/home/deploy/.m2/repository), central (https://repo.maven.apache.org/maven2)] -> [Help 1]
  spring-boot-kafka-microservice-email_1  | [ERROR] 

This error is from the mis-configuration of docker-compose, Deocker

Basically, 

```aidl
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

```aidl
        location /messaging {
            set $upstream spring-boot-kafka-microservice-email;
            set $contextpath /messaging;
```

-- restructured need to be taken care



# finance-service-demo

Use Java 17, Spring Boot 3+, R2DBC

## Build docker image and publish

```bash
set codename tom
#set codename puma
#set codename tiger
```

```bash
chmod +x gradlew
./gradlew clean bootJar
docker build -t finance-service-graphql-reactive:$codename .
docker tag finance-service-graphql-reactive:$codename localhost:5100/finance-service-graphql-reactive:$codename
docker push localhost:5100/finance-service-graphql-reactive:$codename
```

# Resources

https://learn.microsoft.com/zh-cn/azure/developer/java/spring-framework/configure-spring-data-r2dbc-with-azure-mysql
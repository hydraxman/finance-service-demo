# finance-service-demo

Use Java 17, Spring Boot 3+, R2DBC

## Build docker image and publish

```bash
chmod +x gradlew
./gradlew clean bootJar
docker build -t finance-service-graphql-reactive:latest .
docker tag finance-service-graphql-reactive:latest localhost:5100/finance-service-graphql-reactive:latest
docker push localhost:5100/finance-service-graphql-reactive:latest
```

# Resources

https://learn.microsoft.com/zh-cn/azure/developer/java/spring-framework/configure-spring-data-r2dbc-with-azure-mysql
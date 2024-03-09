docker build -t finance-service-graphql-reactive:latest .
docker tag finance-service-graphql-reactive:latest localhost:5100/finance-service-graphql-reactive:latest
docker push localhost:5100/finance-service-graphql-reactive:latest
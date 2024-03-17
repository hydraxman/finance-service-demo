# run this after: ./gradlew.bat :bootJar
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

# 设置工作目录
#WORKDIR /app

# 将构建好的jar文件复制到镜像中
COPY build/libs/*.jar app.jar

# 暴露8080端口
EXPOSE 8080

# 设置环境变量
#ENV SPRING_DATASOURCE_USERNAME=admin
#ENV SPRING_DATASOURCE_PASSWORD=dcba4321
#ENV SPRING_DATASOURCE_URL=r2dbc:postgresql://localhost:5432/finance

# 启动Spring Boot应用
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=k8s"]
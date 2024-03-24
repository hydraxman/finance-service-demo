# run this after: ./gradlew.bat :bootJar
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

# 设置工作目录
#WORKDIR /app

# 将构建好的jar文件复制到镜像中
COPY build/libs/*.jar app.jar

# 暴露8080端口
EXPOSE 8080

# 设置环境变量
#ENV APP_VERSION_CODE_NAME=Tomcat
#ENV APP_VERSION_CODE_NAME=Puma
ENV APP_VERSION_CODE_NAME=Tiger

# 启动Spring Boot应用
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=k8s"]
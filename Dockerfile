FROM openjdk:8-alpine
COPY ./build/libs/ /usr/apps
WORKDIR /usr/apps
EXPOSE 9000

CMD ["java" ,"-jar", "/usr/apps/http4k-demo-1.0-SNAPSHOT.jar"]
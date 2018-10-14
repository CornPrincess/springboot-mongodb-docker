#FROM openjdk:8-jre

#COPY target/springboot-mongodb-docker-0.0.1-SNAPSHOT.jar app.jar

#ENTRYPOINT ["java", "-jar", "/app.jar"]


FROM maven

ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve

ADD src /tmp/build/src
        #构建应用
RUN cd /tmp/build && mvn -q -DskipTests=true package \
        #拷贝编译结果到指定目录
        && mv target/*.jar /app.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build

VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
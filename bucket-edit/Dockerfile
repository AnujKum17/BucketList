FROM maven:3.6.3-openjdk-8 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn package

FROM tomcat:7.0-jdk8-openjdk
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=MAVEN_BUILD /build/target/bucket-edit.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]

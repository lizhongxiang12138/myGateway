FROM openjdk:8-jre-alpine
MAINTAINER lzx <953934680@qq.com>

ENTRYPOINT ["/usr/bin/java","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-jar","/usr/share/eurekaManage/myGateway.jar"]

ARG JAR_FILE
ADD target/myGateway-0.0.1-SNAPSHOT.jar /usr/share/eurekaManage/myGateway.jar
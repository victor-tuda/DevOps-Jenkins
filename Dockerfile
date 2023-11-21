FROM openjdk:17.0.1

WORKDIR ./
COPY target/*.jar /api-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar api-0.0.1-SNAPSHOT.jar
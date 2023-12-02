FROM openjdk:17.0.1

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 9090

CMD ["./mvnw", "spring-boot:run"]
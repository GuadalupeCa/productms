FROM openjdk:11
WORKDIR /productms
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
EXPOSE 8082
CMD ["./mvnw", "spring-boot:run"]
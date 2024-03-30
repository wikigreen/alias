FROM oven/bun:1 as frontBuild
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
WORKDIR $HOME/src/main/frontend
RUN bun install && \
     bun run install
#
# Build stage
#
FROM maven:3.9.6-eclipse-temurin-21-alpine as backBuild
ENV HOME=/usr/app
WORKDIR $HOME
ADD . $HOME
COPY --from=frontBuild $HOME/src/main/frontend/dist $HOME/src/main/frontend/dist
RUN mvn clean package -Pdocker

#
# Package stage
#
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=backBuild $JAR_FILE /app/runner.jar
EXPOSE 8080
ENTRYPOINT java -jar /app/runner.jar
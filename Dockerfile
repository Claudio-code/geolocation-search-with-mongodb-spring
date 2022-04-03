FROM gradle:jdk17 as builder

WORKDIR /builder

COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN gradle build --no-daemon

FROM openjdk:17-slim-bullseye

RUN apt-get update \
    && apt-get upgrade -y \
    && apt-get install -y locales \
    && locale-gen en_US.UTF-8

RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

COPY --from=builder /builder/build/libs/geolocation-search-with-mongodb-spring-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

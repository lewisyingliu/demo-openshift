FROM gradle:jdk17-alpine AS build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle clean build -x test

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
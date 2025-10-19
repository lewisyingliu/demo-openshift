FROM registry.access.redhat.com/ubi8/openjdk-17-devel AS build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle clean build -x test

# Stage 2: Create the final image
FROM registry.access.redhat.com/ubi8/openjdk-17-runtime
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:latest

RUN useradd -ms /bin/bash newuser -u 10001

USER 10001

COPY target/*.jar /opt/app/app.jar

EXPOSE 8080

WORKDIR /opt/app
ENTRYPOINT exec java $JAVA_OPTS  $D_OPTS $SPRING_OPTS -jar /opt/app/app.jar
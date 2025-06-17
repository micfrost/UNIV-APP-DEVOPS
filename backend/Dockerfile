# uzyj oficjalnego obrazu Javy jako bazy
FROM openjdk:21-slim

# ustaw argument dla pliku JAR
ARG JAR_FILE=target/*.jar

# skopiuj plik .jar do kontenera
COPY ${JAR_FILE} app.jar

# uruchom aplikacje przy starcie kontenera
ENTRYPOINT ["java", "-jar", "/app.jar"]


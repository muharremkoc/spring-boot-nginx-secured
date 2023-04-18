FROM openjdk:17-alpine
ADD target/noteService.jar noteService.jar
EXPOSE 2023
ENTRYPOINT ["java","-jar","noteService.jar"]
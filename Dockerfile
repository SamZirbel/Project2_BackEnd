FROM maven:3-jdk-8
COPY target/*-dependencies.jar MyApp.jar
EXPOSE 8085
CMD ["java","-jar","moviebook.jar"]

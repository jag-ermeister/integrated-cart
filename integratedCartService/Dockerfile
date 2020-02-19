FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY build/libs/integratedCartService.jar /opt/app
CMD ["java", "-jar", "/opt/app/integratedCartService.jar"]

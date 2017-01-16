FROM java:8
EXPOSE 8080
COPY ./target/classes/index/* /tmp/catho/
COPY ./target/classes/files/* /tmp/catho/
COPY ./target/opportunity-1.0-SNAPSHOT.jar /
CMD java -jar opportunity-1.0-SNAPSHOT.jar

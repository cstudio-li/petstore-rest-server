#FROM launcher.gcr.io/google/jetty
#ADD target/petstore-rest-server-1.0.0.war $APP_DESTINATION_WAR
#RUN /scripts/jetty/quickstart.sh
FROM gcr.io/google-appengine/jetty
ADD target/petstore-rest-server-1.0.0.war $JETTY_BASE/webapps/root.war
WORKDIR $JETTY_BASE
RUN java -jar $JETTY_HOME/start.jar --approve-all-licenses --add-to-startd=jmx,stats,hawtio && chown -R jetty:jetty $JETTY_BASE
#RUN java -jar $JETTY_HOME/start.jar --approve-all-licenses  && chown -R jetty:jetty $JETTY_BASE

#FROM gcr.io/google-appengine/openjdk:8
#COPY petstore-rest-server-1.0.0.jar $APP_DESTINATION
#FROM jetty:9.4-jdk8
#ADD target/petstore-rest-server-1.0.0.war $$JETTY_BASE/webapps/rest.war

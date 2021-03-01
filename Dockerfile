FROM gcr.io/google-appengine/jetty
ADD target/petstore-rest-server-1.0.0.war $JETTY_BASE/webapps/root.war
WORKDIR $JETTY_BASE
RUN java -jar $JETTY_HOME/start.jar --approve-all-licenses --add-to-startd=jmx,stats,hawtio && chown -R jetty:jetty $JETTY_BASE
#FROM gcr.io/google-appengine/openjdk:8
#COPY petstore-rest-server-1.0.0.jar $APP_DESTINATION

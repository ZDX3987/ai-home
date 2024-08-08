FROM openjdk:8u302-jre
COPY target/ai-home.jar /blog_server/
EXPOSE 9111
ENTRYPOINT [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9000", "-jar", "/blog_server/ai_home.jar" ]
FROM instructure/java

USER docker
COPY "soseedygrpc-all.jar" .

EXPOSE 50051

CMD ["/tini", "--", "/usr/bin/java", "-jar", "soseedygrpc-all.jar", "plain"]

#!/bin/bash

set -euxo pipefail

# build soseedygrpc-all.jar for docker container
SSL_FOLDER="../../soseedygrpc/openssl"
SSL_TARGET="../../soseedygrpc/src/main/resources/"

cp "$SSL_FOLDER/ca.crt"      "$SSL_TARGET"
cp "$SSL_FOLDER/client.crt"  "$SSL_TARGET"
cp "$SSL_FOLDER/client.pem"  "$SSL_TARGET"
cp "$SSL_FOLDER/server.crt"  "$SSL_TARGET"
cp "$SSL_FOLDER/server.pem"  "$SSL_TARGET"

cd "../../soseedygrpc"
gradle clean fatJar
cd -

cp "../../soseedygrpc/build/libs/soseedygrpc-all.jar" .

docker build -t gcr.io/delta-essence-114723/ssl_passthrough .
docker push gcr.io/delta-essence-114723/ssl_passthrough

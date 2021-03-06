#!/bin/bash

./clean.sh

# See mutual auth generation script:
# https://github.com/grpc/grpc-java/tree/master/examples

SIZE=2048

CN_CA=foo
CN_SERVER=example.com
CN_CLIENT=localhost

# CA
openssl genrsa -out ca.key $SIZE
openssl req -new -x509 -days 365 -key ca.key -out ca.crt -subj "/CN=${CN_CA}"

# Server
openssl genrsa -out server.key $SIZE
openssl req -new -key server.key -out server.csr -subj "/CN=${CN_SERVER}"
openssl x509 -req -days 365 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt

# Client
openssl genrsa -out client.key $SIZE
openssl req -new -key client.key -out client.csr -subj "/CN=${CN_CLIENT}"
openssl x509 -req -days 365 -in client.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out client.crt

# netty only supports PKCS8 keys. openssl is used to convert from PKCS1 to PKCS8
# http://netty.io/wiki/sslcontextbuilder-and-private-key.html
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem

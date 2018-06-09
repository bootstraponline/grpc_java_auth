#!/bin/bash

./clean.sh

# See mutual auth generation script:
# https://github.com/grpc/grpc-java/tree/master/examples

SIZE=2048
# CN of CA and CLIENT must match for mutual auth
CN_CA_CLIENT=grpc_auth
CN_SERVER=example.com

# CA
openssl genrsa -out ca.key $SIZE
# Generates ca.crt which is the trustCertCollectionFile
openssl req -new -x509 -days 365 -key ca.key -out ca.crt -subj "/CN=${CN_CA_CLIENT}"

# Server
openssl genrsa -out server.key $SIZE
openssl req -new -key server.key -out server.csr -subj "/CN=${CN_SERVER}"
# Generates server.crt which is the certChainFile for the server
openssl x509 -req -days 365 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt

# Client
openssl genrsa -out client.key $SIZE
openssl req -new -key client.key -out client.csr -subj "/CN=${CN_CA_CLIENT}"

echo Self-signed client certificate:
# Generates client.crt which is the clientCertChainFile for the client (need for mutual TLS only)
openssl x509 -req -days 365 -in client.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out client.crt

# netty only supports PKCS8 keys. openssl is used to convert from PKCS1 to PKCS8
# http://netty.io/wiki/sslcontextbuilder-and-private-key.html
echo Converting the private keys to X.509:
# Generates client.pem which is the clientPrivateKeyFile for the Client (needed for mutual TLS only)
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem
# Generates server.pem which is the privateKeyFile for the Server
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem

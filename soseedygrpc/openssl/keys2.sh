#!/bin/bash
# https://github.com/grpc/grpc-java/tree/master/examples

# Changes these CN's to match your hosts in your environment if needed.
SERVER_CN="example.com"
CLIENT_CN="localhost" # Used when doing mutual TLS
SUBJ_PREFIX="/C=US/ST=State/L=Location/O=Org/OU=OrgUnit"
SIZE=2048

echo Generate CA key:
openssl genrsa -out ca.key "$SIZE"
echo Generate CA certificate:
# Generates ca.crt which is the trustCertCollectionFile
openssl req  -new -x509 -days 365 -key ca.key -out ca.crt -subj "$SUBJ_PREFIX/CN=${SERVER_CN}"
echo Generate server key:
openssl genrsa -out server.key "$SIZE"
echo Generate server signing request:
openssl req  -new -key server.key -out server.csr -subj "$SUBJ_PREFIX/CN=${SERVER_CN}"
echo Self-signed server certificate:
# Generates server.crt which is the certChainFile for the server
openssl x509 -req  -days 365 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt
echo Remove passphrase from server key:
openssl rsa  -in server.key -out server.key

echo Generate client key
openssl genrsa -out client.key "$SIZE"
echo Generate client signing request:
openssl req  -new -key client.key -out client.csr -subj "$SUBJ_PREFIX/CN=${CLIENT_CN}"
echo Self-signed client certificate:
# Generates client.crt which is the clientCertChainFile for the client (need for mutual TLS only)
openssl x509  -req -days 365 -in client.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out client.crt
echo Remove passphrase from client key:
openssl rsa  -in client.key -out client.key
echo Converting the private keys to X.509:
# Generates client.pem which is the clientPrivateKeyFile for the Client (needed for mutual TLS only)
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem
# Generates server.pem which is the privateKeyFile for the Server
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem

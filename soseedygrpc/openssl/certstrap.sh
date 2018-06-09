#!/bin/bash

# **DON'T USE** Replaced by cfssl.sh

./clean.sh

# Certstrap is a tool from square for working with certs.
# Certstrap is in maintence mode and not actively developed.
# https://github.com/square/certstrap
go get -u github.com/square/certstrap

# See mutual auth generation script:
# https://github.com/grpc/grpc-java/tree/master/examples

SIZE=2048

# CA
certstrap --depot-path . init --passphrase '' --common-name example.com --key-bits $SIZE
mv ./example.com.key ./ca.key
mv ./example.com.crt ./ca.crt
mv ./example.com.crl ./ca.crl

# Server
certstrap --depot-path . request-cert --passphrase '' --common-name example.com --domain 'example.com'  --key-bits $SIZE
mv ./example.com.key server.key
mv ./example.com.csr server.csr

certstrap --depot-path . sign server --CA ca
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem

# Client
certstrap --depot-path . request-cert --passphrase '' --common-name example.com --domain 'example.com'  --key-bits $SIZE
mv ./example.com.key client.key
mv ./example.com.csr client.csr

certstrap --depot-path . sign client --CA ca
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem

# netty only supports PKCS8 keys. openssl is used to convert from PKCS1 to PKCS8
# http://netty.io/wiki/sslcontextbuilder-and-private-key.html

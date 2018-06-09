#!/bin/bash

rm -rf *.crl *.key *.crt *.csr

go get -u github.com/square/certstrap

# CA
certstrap --depot-path . init --passphrase '' --common-name ca
openssl pkcs8 -topk8 -nocrypt -in ca.key -out ca.pem

# Server
certstrap --depot-path . request-cert --passphrase '' --common-name server --domain 'example.com'
certstrap --depot-path . sign server --CA ca
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem

# Client
certstrap --depot-path . request-cert --passphrase '' --common-name client --domain 'example.com'
certstrap --depot-path . sign client --CA ca
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem

# netty only supports PKCS8 keys. openssl is used to convert from PKCS1 to PKCS8
# http://netty.io/wiki/sslcontextbuilder-and-private-key.html

package com.instructure.dataseeding.mutual_auth

import java.io.File

object Certs {

    // ca.crt     = trustCertCollectionFile
    // server.crt = certChainFile for the server
    // client.crt = clientCertChainFile for the client (need for mutual TLS only)
    // client.pem = clientPrivateKeyFile for the Client (needed for mutual TLS only)
    // server.pem = privateKeyFile for the Server

    private const val root = "./openssl" // TODO: make relative
    var certChainFile = File("$root/server.crt")
    var privateKeyFile = File("$root/server.pem")
    var clientCertChainFile = File("$root/client.crt")
    var trustCertCollectionFile = File("$root/ca.crt")
    var clientPrivateKeyFile = File("$root/client.pem")
}

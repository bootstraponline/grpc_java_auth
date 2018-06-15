package com.instructure.dataseeding.util

import java.io.File

object Certs {

    // ca.crt     = trustCertCollectionFile
    // server.crt = certChainFile for the server
    // client.crt = clientCertChainFile for the client (need for mutual TLS only)
    // client.pem = clientPrivateKeyFile for the Client (needed for mutual TLS only)
    // server.pem = privateKeyFile for the Server

    private const val root = "./openssl"
    var caCert = File("$root/ca.crt")
    var serverCert = File("$root/server.crt")
    var serverPrivateKey = File("$root/server.pem")
    var clientCert = File("$root/client.crt")
    var clientPrivateKey = File("$root/client.pem")
}

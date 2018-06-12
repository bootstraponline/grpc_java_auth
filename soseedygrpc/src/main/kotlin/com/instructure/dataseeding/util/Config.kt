package com.instructure.dataseeding.util

import io.grpc.netty.GrpcSslContexts
import io.netty.handler.ssl.ClientAuth
import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.SslProvider
import java.io.File
import java.net.InetSocketAddress
import javax.net.ssl.SSLException

object Config {

    val localhost = InetSocketAddress("localhost", 50051)
    val exampleDotCom = InetSocketAddress("example.com", 50051)

    fun serverSslContext(serverCert: File?,
                         serverPrivateKey: File?,
                         caCert: File? = null): SslContext {
        val sslClientContextBuilder = SslContextBuilder.forServer(serverCert, serverPrivateKey)
        if (caCert != null) {
            sslClientContextBuilder.trustManager(caCert)
            sslClientContextBuilder.clientAuth(ClientAuth.REQUIRE)
        }
        return GrpcSslContexts.configure(sslClientContextBuilder, SslProvider.OPENSSL).build()
    }

    @Throws(SSLException::class)
    fun clientSslContext(trustCertCollection: File?,
                         clientCertChain: File? = null,
                         clientPrivateKey: File? = null): SslContext {
        val builder = GrpcSslContexts.forClient()
        if (trustCertCollection != null) {
            builder.trustManager(trustCertCollection)
        }
        if (clientCertChain != null && clientPrivateKey != null) {
            builder.keyManager(clientCertChain, clientPrivateKey)
        }
        return builder.build()
    }
}

package com.instructure.dataseeding.mutual.auth

import com.instructure.dataseeding.util.*
import io.grpc.netty.NettyServerBuilder

object MutualAuthServerTls : CreateServer {
    override fun createServer(): BaseServer {
        val sslContext = Config.serverSslContext(
                Certs.serverCert,
                Certs.serverPrivateKey,
                Certs.caCert)

        val nettyServer = NettyServerBuilder.forAddress(Config.localhost)
                .addService(EchoGrpcImpl())
                .sslContext(sslContext)
                .build()

        return BaseServer(nettyServer)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        createServer().startAndBlockUntilShutdown()
    }
}

package com.instructure.dataseeding.mutual_auth

import Config
import com.instructure.dataseeding.BaseServer
import com.instructure.dataseeding.EchoGrpcImpl
import io.grpc.netty.NettyServerBuilder

object MutualAuthServerTls {
    @JvmStatic
    fun main(args: Array<String>) {
        val sslContext = Config.serverSslContext(
                Certs.certChainFile,
                Certs.privateKeyFile,
                Certs.clientCertChainFile)

        val nettyServer = NettyServerBuilder.forAddress(Config.localhost)
                .addService(EchoGrpcImpl())
                .sslContext(sslContext)
                .build()

        val server = BaseServer(nettyServer)
        server.startAndBlockUntilShutdown()
    }
}

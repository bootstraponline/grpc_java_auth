package com.instructure.dataseeding.mutual.auth

import com.instructure.dataseeding.util.Config
import com.instructure.dataseeding.util.BaseServer
import com.instructure.dataseeding.util.EchoGrpcImpl
import com.instructure.dataseeding.util.Certs
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

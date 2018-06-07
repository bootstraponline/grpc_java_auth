package com.instructure.dataseeding.regular.tls

import com.instructure.dataseeding.util.Config
import com.instructure.dataseeding.util.BaseServer
import com.instructure.dataseeding.util.EchoGrpcImpl
import com.instructure.dataseeding.util.Certs
import io.grpc.netty.NettyServerBuilder

object ServerTls {
    @JvmStatic
    fun main(args: Array<String>) {
        val sslContext = Config.serverSslContext(
                Certs.certChainFile,
                Certs.privateKeyFile)

        val nettyServer = NettyServerBuilder.forAddress(Config.localhost)
                .addService(EchoGrpcImpl())
                .sslContext(sslContext)
                .build()

        val server = BaseServer(nettyServer)
        server.startAndBlockUntilShutdown()
    }
}

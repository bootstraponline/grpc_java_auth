package com.instructure.dataseeding.regular.tls

import com.instructure.dataseeding.util.*
import io.grpc.netty.NettyServerBuilder

object ServerTls : CreateServer {
    override fun createServer(): BaseServer {
        val sslContext = Config.serverSslContext(
                Certs.serverCert,
                Certs.serverPrivateKey)

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

package com.instructure.dataseeding.token.auth

import com.instructure.dataseeding.util.*
import io.grpc.ServerInterceptors
import io.grpc.netty.NettyServerBuilder

object TokenAuthServer : CreateServer {
    override fun createServer(): BaseServer {
        val sslContext = Config.serverSslContext(
                Certs.serverCert,
                Certs.serverPrivateKey,
                Certs.caCert)

        val nettyServer = NettyServerBuilder.forAddress(Config.localhost)
                .addService(ServerInterceptors.interceptForward(EchoGrpcImpl(), ServerAuthInterceptor()))
                .sslContext(sslContext)
                .build()

        return BaseServer(nettyServer, this)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        createServer().startAndBlockUntilShutdown()
    }
}

package com.instructure.dataseeding.mutual_auth

import com.instructure.dataseeding.BaseServer
import com.instructure.dataseeding.EchoGrpcImpl
import io.grpc.netty.GrpcSslContexts
import io.grpc.netty.NettyServerBuilder
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.SslProvider
import java.net.InetSocketAddress

object ServerTls {
    private val sslContext = GrpcSslContexts.configure(
            SslContextBuilder.forServer(Certs.certChainFile, Certs.privateKeyFile),
            SslProvider.OPENSSL)
            .build()

    @JvmStatic
    fun main(args: Array<String>) {

        val nettyServer = NettyServerBuilder.forAddress(InetSocketAddress("localhost", 50051))
                .addService(EchoGrpcImpl())
                .sslContext(sslContext)
                .useTransportSecurity(Certs.certChainFile, Certs.privateKeyFile)
                .build()

        val server = BaseServer(nettyServer)
        server.startAndBlockUntilShutdown()
    }
}

package com.instructure.dataseeding.mutual_auth

import com.instructure.dataseeding.BaseServer
import com.instructure.dataseeding.EchoGrpcImpl
import io.grpc.netty.GrpcSslContexts
import io.grpc.netty.NettyServerBuilder
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.SslProvider
import java.net.InetSocketAddress

object ServerTls {

    private val sslContextBuilder: SslContextBuilder
        get() {
            val sslClientContextBuilder = SslContextBuilder.forServer(Certs.certChainFile, Certs.privateKeyFile)
            return GrpcSslContexts.configure(sslClientContextBuilder, SslProvider.OPENSSL)
        }

    @JvmStatic
    fun main(args: Array<String>) {

        val nettyServer = NettyServerBuilder.forAddress(InetSocketAddress("localhost", 50051))
                .addService(EchoGrpcImpl())
                .sslContext(sslContextBuilder.build())
                .useTransportSecurity(Certs.certChainFile, Certs.privateKeyFile)
                .build()

        val server = BaseServer(nettyServer)
        server.startAndBlockUntilShutdown()
    }
}

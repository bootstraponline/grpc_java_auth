/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.instructure.dataseeding.regular_tls

import com.instructure.dataseeding.mutual_auth.Certs
import com.instructure.soseedy.HealthCheck
import com.instructure.soseedy.HealthCheckRequest
import com.instructure.soseedy.SeedyGeneralGrpc
import io.grpc.ManagedChannel
import io.grpc.StatusRuntimeException
import io.grpc.netty.GrpcSslContexts
import io.grpc.netty.NegotiationType
import io.grpc.netty.NettyChannelBuilder
import io.netty.handler.ssl.SslContext
import java.io.File
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import java.util.logging.Logger
import javax.net.ssl.SSLException

/**
 * A simple client that requests a greeting from the HelloWorldServer with TLS.
 */
class ClientTls
/**
 * Construct client for accessing RouteGuide server using the existing channel.
 */
internal constructor(private val channel: ManagedChannel) {
    private val blockingStub: SeedyGeneralGrpc.SeedyGeneralBlockingStub

    /**
     * Construct client connecting to HelloWorld server at `host:port`.
     */
    @Throws(SSLException::class)
    constructor(host: String,
                port: Int,
                sslContext: SslContext) : this(NettyChannelBuilder.forAddress(host, port)
            .negotiationType(NegotiationType.TLS)
            .sslContext(sslContext)
            .build()) {
    }

    init {
        blockingStub = SeedyGeneralGrpc.newBlockingStub(channel)
    }

    @Throws(InterruptedException::class)
    fun shutdown() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

    /**
     * Say hello to server.
     */
    fun greet(name: String) {
        logger.info("Will try to greet $name ...")
        val response: HealthCheck
        try {
            response = blockingStub.getHealthCheck(HealthCheckRequest.getDefaultInstance())
        } catch (e: StatusRuntimeException) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.status)
            return
        }

        logger.info("Greeting: " + response.healthy)
    }

    companion object {
        private val logger = Logger.getLogger(ClientTls::class.java.name)

        @Throws(SSLException::class)
        private fun buildSslContext(trustCertCollectionFilePath: String?,
                                    clientCertChainFilePath: String?,
                                    clientPrivateKeyFilePath: String?): SslContext {
            val builder = GrpcSslContexts.forClient()
            if (trustCertCollectionFilePath != null) {
                builder.trustManager(File(trustCertCollectionFilePath))
            }
            if (clientCertChainFilePath != null && clientPrivateKeyFilePath != null) {
                builder.keyManager(File(clientCertChainFilePath), File(clientPrivateKeyFilePath))
            }
            return builder.build()
        }

        /**
         * Greet server. If provided, the first element of `args` is the name to use in the
         * greeting.
         */
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {

            println("USAGE: ClientTls host port [trustCertCollectionFilePath] " +
                    "[clientCertChainFilePath] [clientPrivateKeyFilePath]\n  Note: clientCertChainFilePath and " +
                    "clientPrivateKeyFilePath are only needed if mutual auth is desired. And if you specify " +
                    "clientCertChainFilePath you must also specify clientPrivateKeyFilePath")

            val host = "localhost"
            val port = 50051
            val trustCertCollectionFilePath = Certs.trustCertCollectionFile.toString()

            val client = ClientTls(host, port,
                    buildSslContext(trustCertCollectionFilePath, null, null))


            try {
                /* Access a service running on the local machine on port 50051 */
                var user = "world"
                if (args.size > 0) {
                    user = args[0] /* Use the arg as the name to greet if provided */
                }
                client.greet(user)
            } finally {
                client.shutdown()
            }
        }
    }
}

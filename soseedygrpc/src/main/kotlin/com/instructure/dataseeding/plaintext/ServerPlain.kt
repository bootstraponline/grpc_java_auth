package com.instructure.dataseeding.plaintext

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

import com.instructure.dataseeding.EchoGrpcImpl
import io.grpc.Server
import io.grpc.netty.GrpcSslContexts
import io.grpc.netty.NettyServerBuilder
import io.netty.handler.ssl.ClientAuth
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.SslProvider
import java.io.File
import java.io.IOException
import java.net.InetSocketAddress
import java.util.logging.Logger

/** Server that manages startup/shutdown of a `Greeter` server with TLS enabled.  */
class ServerPlain(
        private val host: String,
        private val port: Int) {

    private var server: Server? = null


    @Throws(IOException::class)
    private fun start() {
        server = NettyServerBuilder.forAddress(InetSocketAddress(host, port))
                .addService(EchoGrpcImpl())
                .build()
                .start()
        logger.info("Server started, listening on $port")
        Runtime.getRuntime()
                .addShutdownHook(
                        object : Thread() {
                            override fun run() {
                                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                                this@ServerPlain.stop()
                                System.err.println("*** server shut down")
                            }
                        })
    }

    private fun stop() {
        if (server != null) {
            server!!.shutdown()
        }
    }

    /** Await termination on the main thread since the grpc library uses daemon threads.  */
    @Throws(InterruptedException::class)
    private fun blockUntilShutdown() {
        if (server != null) {
            server!!.awaitTermination()
        }
    }

    companion object {
        private val logger = Logger.getLogger(ServerPlain::class.java.name)

        /** Main launches the server from the command line.  */
        @Throws(IOException::class, InterruptedException::class)
        @JvmStatic
        fun main(args: Array<String>) {

            println(
                    "USAGE: ServerTls host port certChainFilePath privateKeyFilePath "
                            + "[clientCertChainFilePath]\n  Note: You only need to supply clientCertChainFilePath if you want "
                            + "to enable Mutual TLS.")

            val host = "localhost"
            val port = 50051

            println("Starting ServerTls")

            val server = ServerPlain(
                    host, port)
            server.start()
            server.blockUntilShutdown()
        }
    }
}


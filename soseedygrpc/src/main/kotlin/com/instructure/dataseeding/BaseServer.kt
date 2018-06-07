package com.instructure.dataseeding

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

import io.grpc.Server
import java.io.IOException
import java.util.logging.Logger

/** Server that manages startup/shutdown of a `Greeter` server with TLS enabled.  */
class BaseServer(
        private val server: Server) {

    @Throws(IOException::class)
    fun startAndBlockUntilShutdown() {
        server.start()
        logger.info("Server started, listening on ${server.port}")
        Runtime.getRuntime()
                .addShutdownHook(
                        object : Thread() {
                            override fun run() {
                                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                                this@BaseServer.stop()
                                System.err.println("*** server shut down")
                            }
                        })

        server.awaitTermination()
    }

    private fun stop() {
        server.shutdown()
    }

    companion object {
        private val className = BaseServer::class.java.simpleName
        private val logger = Logger.getLogger(className)
    }
}

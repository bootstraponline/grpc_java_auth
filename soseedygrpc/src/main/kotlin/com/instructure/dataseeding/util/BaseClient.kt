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

package com.instructure.dataseeding.util

import com.instructure.soseedy.EchoGrpc
import com.instructure.soseedy.EchoRequest
import com.instructure.soseedy.EchoResponse
import io.grpc.ManagedChannel
import io.grpc.StatusRuntimeException
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import java.util.logging.Logger

class BaseClient(var channel: ManagedChannel) {
    private val blockingStub: EchoGrpc.EchoBlockingStub = EchoGrpc.newBlockingStub(channel)

    @Throws(InterruptedException::class)
    private fun shutdown() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

    private fun greet(name: String): String {
        logger.info("Will try to greet $name ...")
        val response: EchoResponse
        try {
            val request = EchoRequest.newBuilder().setText(name).build()
            response = blockingStub.get(request)
        } catch (e: StatusRuntimeException) {
            logger.log(Level.WARNING, "RPC failed")
            throw e
        }

        logger.info("Greeting: " + response.text)
        return response.text
    }

    fun greetAndShutdown(): String {
        try {
            val user = "world"
            return this.greet(user)
        } finally {
            this.shutdown()
        }
    }

    companion object {
        private val logger = Logger.getLogger(BaseClient::class.java.name)
    }
}

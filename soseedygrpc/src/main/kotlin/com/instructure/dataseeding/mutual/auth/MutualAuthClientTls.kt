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

package com.instructure.dataseeding.mutual.auth

import com.instructure.dataseeding.util.BaseClient
import com.instructure.dataseeding.util.Certs
import com.instructure.dataseeding.util.Config
import com.instructure.dataseeding.util.RunClient
import io.grpc.netty.NegotiationType
import io.grpc.netty.NettyChannelBuilder
import java.net.InetSocketAddress

object MutualAuthClientTls : RunClient {
    override fun runClient(address: InetSocketAddress): String {
        val sslContext = Config.clientSslContext(
                Certs.caCert,
                Certs.clientCert,
                Certs.clientPrivateKey)

        val channel = NettyChannelBuilder.forAddress(address)
                .negotiationType(NegotiationType.TLS)
                .sslContext(sslContext)
                .overrideAuthority(Config.exampleDotCom.hostName)
                .build()

        return BaseClient(channel, this).greetAndShutdown()
    }

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        runClient()
    }
}

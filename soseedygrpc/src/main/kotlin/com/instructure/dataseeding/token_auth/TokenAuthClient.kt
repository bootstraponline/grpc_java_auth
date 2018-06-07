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

import Config
import com.instructure.dataseeding.BaseClient
import com.instructure.dataseeding.mutual_auth.Certs
import com.instructure.dataseeding.token_auth.ClientAuthInterceptor
import io.grpc.netty.NegotiationType
import io.grpc.netty.NettyChannelBuilder

object TokenAuthClientTls {

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val sslContext = Config.clientSslContext(
                Certs.trustCertCollectionFile,
                Certs.clientCertChainFile,
                Certs.clientPrivateKeyFile)

        val channel = NettyChannelBuilder.forAddress(Config.exampleDotCom)
                .negotiationType(NegotiationType.TLS)
                .sslContext(sslContext)
                .intercept(ClientAuthInterceptor())
                .build()

        BaseClient(channel).greetAndShutdown()
    }
}

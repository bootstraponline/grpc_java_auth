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

import Config
import com.instructure.dataseeding.BaseServer
import com.instructure.dataseeding.EchoGrpcImpl
import io.grpc.netty.NettyServerBuilder

object ServerPlain {

    @JvmStatic
    fun main(args: Array<String>) {
        val nettyServer = NettyServerBuilder.forAddress(Config.localhost)
                .addService(EchoGrpcImpl())
                .build()

        val server = BaseServer(nettyServer)
        server.startAndBlockUntilShutdown()
    }
}

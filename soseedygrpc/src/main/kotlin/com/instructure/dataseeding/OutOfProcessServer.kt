//
// Copyright (C) 2018-present Instructure, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.instructure.dataseeding

import com.instructure.dataseeding.seedyimpls.*
import io.grpc.Server
import io.grpc.netty.GrpcSslContexts
import io.grpc.netty.NettyServerBuilder
import io.netty.handler.ssl.ClientAuth
import java.io.File
import java.io.IOException

private object OutOfProcessServer {
    private const val port = 50051

    private val certChainFile = File("/Users/medwards/code/android-uno/automation/soseedygrpc/openssl/server.crt")
    private val privateKeyFile = File("/Users/medwards/code/android-uno/automation/soseedygrpc/openssl/server.pem")
    private val clientCertChainFile = File("/Users/medwards/code/android-uno/automation/soseedygrpc/openssl/client.crt")

    private val server: Server = NettyServerBuilder.forPort(port)
            .sslContext(GrpcSslContexts.forServer(certChainFile, privateKeyFile)
                    .trustManager(clientCertChainFile)
                    .clientAuth(ClientAuth.REQUIRE)
                    .build())
            .addService(GeneralSeedyImpl())
            .addService(SeedyAssignmentsImpl())
            .addService(SeedyConversationsImpl())
            .addService(SeedyCoursesImpl())
            .addService(SeedyDiscussionsImpl())
            .addService(SeedyEnrollmentsImpl())
            .addService(SeedyFilesImpl())
            .addService(SeedyGradingPeriodsImpl())
            .addService(SeedyGroupsImpl())
            .addService(SeedyPagesImpl())
            .addService(SeedyQuizzesImpl())
            .addService(SeedySectionsImpl())
            .addService(SeedyUsersImpl())
            .build()

    @Throws(IOException::class)
    private fun start() {
        server.start()
        println("Server started on port $port")
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                System.err.println("JVM shutdown hook activated. Shutting down...")
                OutOfProcessServer.stop()
                System.err.println("Server shut down.")
            }
        })
    }

    private fun stop() {
        server.shutdown()
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    @Throws(InterruptedException::class)
    private fun blockUntilShutdown() {
        server.awaitTermination()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        OutOfProcessServer.start()
        OutOfProcessServer.blockUntilShutdown()
    }
}

// todo: java client ... verify SSL connection works. then try Swift again
// maybe ", arguments: [.sslTargetNameOverride("example.com")]" is required

// https://github.com/grpc/grpc-java/tree/master/examples
// https://github.com/grpc/grpc-java/blob/master/examples/src/main/java/io/grpc/examples/helloworldtls/HelloWorldServerTls.java
// https://serverfault.com/questions/9708/what-is-a-pem-file-and-how-does-it-differ-from-other-openssl-generated-key-file
// https://github.com/grpc/grpc-swift/blob/87a7c1baa839f38c14a51a7ae857140973efbee5/Tests/SwiftGRPCTests/BasicEchoTestCase.swift#L50

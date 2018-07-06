package com.instructure.dataseeding

import com.instructure.dataseeding.mutual.auth.MutualAuthServerTls
import com.instructure.dataseeding.plaintext.ServerPlain
import com.instructure.dataseeding.regular.tls.ServerTls
import com.instructure.dataseeding.token.auth.TokenAuthServer

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 1) throw RuntimeException("Expected single arg className")
        val className = args.first()

        val server = when (className) {
            "mutual" -> MutualAuthServerTls.createServer()
            "plain" -> ServerPlain.createServer()
            "tls" -> ServerTls.createServer()
            "token" -> TokenAuthServer.createServer()
            else -> throw RuntimeException("Unknown class $className")
        }

        server.startAndBlockUntilShutdown()
    }
}

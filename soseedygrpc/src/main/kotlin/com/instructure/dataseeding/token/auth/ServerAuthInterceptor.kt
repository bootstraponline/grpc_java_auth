package com.instructure.dataseeding.token.auth

import io.grpc.*

class NoopServerCallListener<ReqT> : ServerCall.Listener<ReqT>()

class ServerAuthInterceptor : ServerInterceptor {

    private val secretToken = "123"

    override fun <ReqT : Any, RespT : Any> interceptCall(
            call: ServerCall<ReqT, RespT>,
            headers: Metadata,
            next: ServerCallHandler<ReqT, RespT>): ServerCall.Listener<ReqT> {

        val authToken = headers.get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER))

        if (authToken != secretToken) {
            call.close(Status.UNAUTHENTICATED, headers)
            return NoopServerCallListener()
        }

        return next.startCall(call, headers)
    }
}

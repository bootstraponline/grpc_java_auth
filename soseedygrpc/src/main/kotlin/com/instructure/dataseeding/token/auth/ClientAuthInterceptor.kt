package com.instructure.dataseeding.token.auth

import io.grpc.*
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall

class AddAuthHeaderClient<ReqT, RespT>(delegate: ClientCall<ReqT, RespT>) : SimpleForwardingClientCall<ReqT, RespT>(delegate) {
    private val authHeaderKey = "123"
    private val authHeaderValue = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER)!!

    override fun start(responseListener: ClientCall.Listener<RespT>, headers: Metadata) {
        headers.put(authHeaderValue, authHeaderKey)
        super.start(responseListener, headers)
    }
}

class ClientAuthInterceptor : ClientInterceptor {
    override fun <ReqT : Any, RespT : Any> interceptCall(
            method: MethodDescriptor<ReqT, RespT>,
            callOptions: CallOptions,
            next: Channel): ClientCall<ReqT, RespT> {

        return AddAuthHeaderClient(next.newCall(method, callOptions))
    }
}

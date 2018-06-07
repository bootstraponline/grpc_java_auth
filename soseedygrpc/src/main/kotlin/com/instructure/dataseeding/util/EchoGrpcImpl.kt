package com.instructure.dataseeding.util

import com.instructure.soseedy.EchoGrpc
import com.instructure.soseedy.EchoRequest
import com.instructure.soseedy.EchoResponse

class EchoGrpcImpl : EchoGrpc.EchoImplBase() {

    override fun get(request: EchoRequest?, responseObserver: io.grpc.stub.StreamObserver<EchoResponse>) {
        val reply = EchoResponse.newBuilder().setText(request?.text).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}

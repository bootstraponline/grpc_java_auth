import io.grpc.netty.GrpcSslContexts
import io.netty.handler.ssl.SslContext
import java.io.File
import javax.net.ssl.SSLException

object Config {

    @Throws(SSLException::class)
    fun clientSslContext(trustCertCollection: File?,
                         clientCertChain: File? = null,
                         clientPrivateKey: File? = null): SslContext {
        val builder = GrpcSslContexts.forClient()
        if (trustCertCollection != null) {
            builder.trustManager(trustCertCollection)
        }
        if (clientCertChain != null && clientPrivateKey != null) {
            builder.keyManager(clientCertChain, clientPrivateKey)
        }
        return builder.build()
    }
}

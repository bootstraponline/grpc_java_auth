package token.auth

import com.google.common.truth.Truth.assertThat
import com.instructure.dataseeding.mutual.auth.MutualAuthClientTls
import com.instructure.dataseeding.mutual.auth.MutualAuthServerTls
import com.instructure.dataseeding.regular.tls.ClientTls
import com.instructure.dataseeding.token.auth.TokenAuthClient
import com.instructure.dataseeding.token.auth.TokenAuthServer
import io.grpc.StatusRuntimeException
import org.junit.Test

class TokenAuthServerTest {

    @Test(expected = StatusRuntimeException::class)
    fun testServerRejectsRegularClient() {
        val server = TokenAuthServer.createServer().start()

        try {
            ClientTls.runClient()
        } finally {
            server.shutdown()
        }
    }

    @Test
    fun testServerAcceptsMutalClient() {
        val server = TokenAuthServer.createServer().start()

        try {
            assertThat(TokenAuthClient.runClient())
                    .isEqualTo("world")
        } finally {
            server.shutdown()
        }

    }
}

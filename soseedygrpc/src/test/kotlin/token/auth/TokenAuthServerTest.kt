package token.auth

import com.instructure.dataseeding.regular.tls.ClientTls
import com.instructure.dataseeding.token.auth.TokenAuthClient
import com.instructure.dataseeding.token.auth.TokenAuthServer
import io.grpc.StatusRuntimeException
import org.junit.Test
import runClientServer

class TokenAuthServerTest {

    @Test(expected = StatusRuntimeException::class)
    fun testServerRejectsRegularClient() {
        runClientServer(TokenAuthServer, ClientTls)
    }

    @Test
    fun testServerAcceptsMutalClient() {
        runClientServer(TokenAuthServer, TokenAuthClient)
    }
}

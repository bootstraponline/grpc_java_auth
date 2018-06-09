package mutual.auth

import com.instructure.dataseeding.mutual.auth.MutualAuthClientTls
import com.instructure.dataseeding.mutual.auth.MutualAuthServerTls
import com.instructure.dataseeding.regular.tls.ClientTls
import io.grpc.StatusRuntimeException
import org.junit.Test
import runClientServer

class MutualAuthServerTlsTest {

    @Test(expected = StatusRuntimeException::class)
    fun testServerRejectsRegularClient() {
        runClientServer(MutualAuthServerTls, ClientTls)
    }

    @Test
    fun testServerAcceptsMutalClient() {
        runClientServer(MutualAuthServerTls, MutualAuthClientTls)
    }
}

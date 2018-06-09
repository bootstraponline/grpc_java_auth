package mutual.auth

import com.google.common.truth.Truth.assertThat
import com.instructure.dataseeding.mutual.auth.MutualAuthClientTls
import com.instructure.dataseeding.mutual.auth.MutualAuthServerTls
import com.instructure.dataseeding.regular.tls.ClientTls
import io.grpc.StatusRuntimeException
import org.junit.Test

class MutualAuthServerTlsTest {

    @Test(expected = StatusRuntimeException::class)
    fun testServerRejectsRegularClient() {
        val server = MutualAuthServerTls.createServer().start()

        try {
            ClientTls.runClient()
        } finally {
            server.shutdown()
        }

    }

    @Test
    fun testServerAcceptsMutalClient() {
        val server = MutualAuthServerTls.createServer().start()

        try {
            assertThat(MutualAuthClientTls.runClient())
                    .isEqualTo("world")
        } finally {
            server.shutdown()
        }

    }
}

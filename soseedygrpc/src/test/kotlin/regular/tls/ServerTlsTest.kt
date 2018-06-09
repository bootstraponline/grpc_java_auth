package regular.tls

import com.google.common.truth.Truth.assertThat
import com.instructure.dataseeding.regular.tls.ClientTls
import com.instructure.dataseeding.regular.tls.ServerTls
import org.junit.Test

class ServerTlsTest {

    @Test
    fun testServerAndClient() {
        val server = ServerTls.createServer().start()

        try {
            assertThat(ClientTls.runClient())
                    .isEqualTo("world")
        } finally {
            server.shutdown()
        }

    }
}

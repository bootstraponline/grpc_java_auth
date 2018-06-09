package plaintext

import com.google.common.truth.Truth.assertThat
import com.instructure.dataseeding.plaintext.ClientPlain
import com.instructure.dataseeding.plaintext.ServerPlain
import com.instructure.dataseeding.regular.tls.ClientTls
import com.instructure.dataseeding.regular.tls.ServerTls
import org.junit.Test

class ServerPlainTest {

    @Test
    fun testServerAndClient() {
        val server = ServerPlain.createServer().start()

        try {
            assertThat(ClientPlain.runClient())
                    .isEqualTo("world")
        } finally {
            server.shutdown()
        }

    }
}

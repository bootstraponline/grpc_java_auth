package regular.tls

import com.instructure.dataseeding.regular.tls.ClientTls
import com.instructure.dataseeding.regular.tls.ServerTls
import org.junit.Test
import runClientServer

class ServerTlsTest {

    @Test
    fun testServerAndClient() {
        runClientServer(ServerTls, ClientTls)
    }
}

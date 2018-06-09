package plaintext

import com.instructure.dataseeding.plaintext.ClientPlain
import com.instructure.dataseeding.plaintext.ServerPlain
import org.junit.Test
import runClientServer

class ServerPlainTest {

    @Test
    fun testServerAndClient() {
        runClientServer(ServerPlain, ClientPlain)
    }
}

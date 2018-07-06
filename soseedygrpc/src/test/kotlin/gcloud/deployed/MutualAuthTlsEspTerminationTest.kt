package gcloud.deployed

import com.google.common.truth.Truth
import com.instructure.dataseeding.mutual.auth.MutualAuthClientTls
import org.junit.Ignore
import org.junit.Test
import java.net.InetSocketAddress

class MutualAuthTlsEspTerminationTest {

    // ESP set up with TLS mutual auth, termination at the load balancer.
    // client -> ESP is TLS mutual auth
    //           ESP -> server is plain text
    @Test
    @Ignore
    fun testClientConnects() {
        val client = MutualAuthClientTls
        val address = InetSocketAddress("35.224.8.72", 80)

        Truth.assertThat(client.runClient(address))
                .isEqualTo("world")
    }
}

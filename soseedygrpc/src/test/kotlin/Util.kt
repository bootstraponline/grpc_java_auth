import com.google.common.truth.Truth
import com.instructure.dataseeding.util.CreateServer
import com.instructure.dataseeding.util.RunClient

fun runClientServer(server: CreateServer, client: RunClient) {
    val runningServer = server.createServer().start()

    try {
        Truth.assertThat(client.runClient())
                .isEqualTo("world")
    } finally {
        runningServer.shutdown()
    }
}

import elastiko.address
import elastiko.healthAsync
import elastiko.settings
import elastiko.transportClient
import nl.komponents.kovenant.DirectDispatcher
import nl.komponents.kovenant.Kovenant
import org.elasticsearch.client.transport.NoNodeAvailableException
import org.elasticsearch.common.unit.TimeValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class ClientTest {
    @Before fun setup() {
        Kovenant.context {
            callbackContext.dispatcher = DirectDispatcher.instance
            workerContext.dispatcher = DirectDispatcher.instance
        }
    }

    @Test fun createTransportClient() {
        val client = transportClient(listOf(address("localhost", 9350))) {
            settings {
                put("cluster.name", "elasticsearch")
            }
        }

        val promise = client.admin().cluster().healthAsync("bank") {
            setTimeout(TimeValue.timeValueSeconds(5))
        }

        assertEquals("OK", promise.get().status().toString())

        client.close()
    }

    @JvmField @Rule val expectRule = ExpectedException.none()
    @Test fun createTransportClientWithInvalidPort() {
        expectRule.expect(NoNodeAvailableException::class.java)
        val client = transportClient(listOf(address("localhost", 9999))) {
            settings {
                put("cluster.name", "elasticsearch")
            }
        }
        val promise = client.admin().cluster().healthAsync("bank") {
            setTimeout(TimeValue.timeValueSeconds(5))
        }
        promise.get()
        client.close()
    }
}

import elastiko.*
import nl.komponents.kovenant.DirectDispatcher
import nl.komponents.kovenant.Kovenant
import nl.komponents.kovenant.functional.bind
import org.elasticsearch.common.unit.TimeValue
import org.elasticsearch.index.query.QueryBuilders
import org.junit.Before
import org.junit.Test

class ClientTest {
    @Before fun setup() {
        Kovenant.context {
            callbackContext.dispatcher = DirectDispatcher.instance
            workerContext.dispatcher = DirectDispatcher.instance
        }
    }

    @Test fun createNodeClient() {

        val (node, client) = nodeClient {
            clusterName("elasticsearch")
            client(true)
            settings {
                put("path.home", "./")
                put("http.enabled", false)
            }
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
        } bind {
            println("success: $it")
            client.searchAsync("bank") {
                setTimeout(TimeValue.timeValueSeconds(5))
                setQuery(QueryBuilders.matchAllQuery())
                setFrom(0)
                setSize(30)
                setExplain(true)
            }
        }

        println(promise.get())

        client.close()
    }
}

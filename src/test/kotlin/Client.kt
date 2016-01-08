import elastiko.*
import nl.komponents.kovenant.*
import nl.komponents.kovenant.functional.withContext
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder
import org.elasticsearch.client.ClusterAdminClient
import org.elasticsearch.common.unit.TimeValue
import org.elasticsearch.index.query.QueryBuilders
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import nl.komponents.kovenant.functional.bind

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

        val h = client.admin().cluster().prepareHealth("bank").execute().actionGet()
        println("h: $h")

        client.admin().cluster().healthAsync("bank") {
            setTimeout(TimeValue.timeValueSeconds(5))
        } bind {
            println("success: ${it.status}")
            client.searchAsync("bank") {
                setTimeout(TimeValue.timeValueSeconds(5))
                setQuery(QueryBuilders.matchAllQuery())
                setFrom(0)
                setSize(30)
                setExplain(true)
            }
        } success {
            println("success: ${it.hits.totalHits}")
        } fail {
            println("fail1: $it")
        }

        println("hoge")

        Thread.sleep(3000)

        //        node.close()
    }
}

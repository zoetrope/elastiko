import elastiko.*
import nl.komponents.kovenant.DirectDispatcher
import nl.komponents.kovenant.Kovenant
import org.elasticsearch.client.Client
import org.elasticsearch.common.unit.TimeValue
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SearchTest {
    lateinit private var client: Client

    @Before fun setup() {
        Kovenant.context {
            callbackContext.dispatcher = DirectDispatcher.instance
            workerContext.dispatcher = DirectDispatcher.instance
        }

        client = transportClient(listOf(address("localhost", 9350))) {
            settings {
                put("cluster.name", "elasticsearch")
            }
        }
    }

    @After fun tearDown() {
        client.close()
    }

    @Test fun allMatch() {

        val p = client.searchAsync("bank"){
            setQuery(matchAllQuery())
            setTimeout(TimeValue.timeValueSeconds(5))
        }

        assertEquals(1000, p.get().hits.totalHits)
    }

    @Test fun range() {

        val p = client.searchAsync("bank"){
            setQuery(rangeQuery("age"){
                from(20)
                to(25)
            })
            setTimeout(TimeValue.timeValueSeconds(5))
        }

        assertEquals(267, p.get().hits.totalHits)
    }
}
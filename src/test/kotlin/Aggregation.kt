import elastiko.*
import nl.komponents.kovenant.DirectDispatcher
import nl.komponents.kovenant.Kovenant
import org.elasticsearch.client.Client
import org.elasticsearch.common.unit.TimeValue
import org.elasticsearch.search.aggregations.bucket.terms.Terms
import org.elasticsearch.search.aggregations.metrics.avg.Avg
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AggregationTest {
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

    @Test fun avg() {

        val p = client.searchAsync("bank"){
            setQuery(matchAllQuery())
            addAggregation(avg("avg_age"){
                field("age")
            })
            setTimeout(TimeValue.timeValueSeconds(5))
        }

        val avg = p.get().aggregations.get<Avg>("avg_age")
        assertEquals(30.171, avg.value)
    }

    @Test fun terms() {

        val p = client.searchAsync("bank"){
            setQuery(matchAllQuery())
            addAggregation(terms("states"){
                field("state")
                size(1000)
                order(Terms.Order.count(false))
            })
            setTimeout(TimeValue.timeValueSeconds(5))
        }

        val states = p.get().aggregations.get<Terms>("states")

        assertEquals(51, states.buckets.size)
        assertEquals("tx", states.buckets[0].key)
        assertEquals(30, states.buckets[0].docCount)
    }
}

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.common.transport.TransportAddress
import org.elasticsearch.index.query.QueryBuilders
import java.net.InetAddress

fun main(args: Array<String>) {
    val h = Hello();
    h.es()
}

class Hello {

    fun es() {
        val client = esClient(listOf(InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300))) {
            settings(esSettings {
                put("cluster.name", "elasticsearch")
            })
        }

        client.searchAsync("*") {
            setSize(10)
            setQuery(QueryBuilders.matchAllQuery())
        } success {
            it.hits?.hits?.forEach {
                println(it.source)
            }
        }
        Thread.sleep(5000)
    }

    fun esSettings(block: Settings.Builder.() -> Unit): Settings {
        val settings = Settings.settingsBuilder()
        settings.block()
        return settings.build()
    }

    fun esClient(nodes: List<TransportAddress>, block: TransportClient.Builder.() -> Unit): TransportClient {
        val builder = TransportClient.builder()
        builder.block()
        val client = builder.build()
        nodes.forEach {
            client.addTransportAddress(it)
        }
        return client
    }

    fun TransportClient.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Throwable> {

        val deferred = deferred<SearchResponse, Throwable>();
        val builder = this.prepareSearch(*indices)
        builder.block()

        builder.execute(object : ActionListener<SearchResponse> {
            override fun onResponse(res: SearchResponse) {
                deferred.resolve(res)
            }

            override fun onFailure(e: Throwable) {
                deferred.reject(e)
            }
        })

        return deferred.promise
    }

}
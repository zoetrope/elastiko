import elastiko.*
import org.elasticsearch.search.aggregations.bucket.terms.Terms

fun main(args: Array<String>) {
    val client = transportClient(listOf(address("localhost", 9350))) {
        settings {
            put("cluster.name", "elasticsearch")
        }
    }
    client.searchAsync("bank") {
        setQuery(matchAllQuery())
        setPostFilter(rangeQuery("age") {
            from(20)
            to(30)
        })
        addAggregation(terms("genders") {
            field("gender")
        })
        setFrom(0)
        setSize(30)
        setExplain(true)
    } success {
        println("success: totalHits=${it.hits.totalHits}")

        val genders: Terms? = it.aggregations?.get("genders");
        genders?.buckets?.forEach {
            println("${it.key}: ${it.docCount}")
        }

        it.hits.hits?.forEach {
            println(it.source)
        }
    } fail {
        it.printStackTrace()
    } always {
        client.close()
    }
    Thread.sleep(5000)
}


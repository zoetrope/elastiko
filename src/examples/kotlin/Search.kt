import elastiko.*

fun main(args: Array<String>) {
    val client = transportClient(listOf(address("localhost", 9350))) {
        settings {
            put("cluster.name", "elasticsearch")
        }
    }
    client.searchAsync("*") {
        setQuery(boolQuery {
            must(termQuery("abc", "100"))
            should(termQuery("def", "100"))
        })
        setPostFilter(rangeQuery("age") {
            from(20)
            to(30)
        })
        addAggregation(avg("test"))
        setFrom(0)
        setSize(30)
        setExplain(true)
    } success {
        println("success: totalHits=${it.hits.totalHits}")

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


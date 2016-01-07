import elastiko.*

fun main(args: Array<String>) {
    val h = Hello();
    h.es()
}

class Hello {

    fun es() {
        val client = transportClient(listOf(address("localhost", 9350))) {
            settings {
                put("cluster.name", "elasticsearch")
            }
        }

        client.searchAsync("*") {
            setQuery(bool {
                must(term("abc", "100"))
                should(term("def", "100"))
            })
            setPostFilter(range("age"){
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
            println("fail")
        }
        Thread.sleep(5000)
    }
}

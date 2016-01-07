import elastiko.*

fun main(args: Array<String>) {
    val (node, client) = nodeClient {
        clusterName("elasticsearch")
        client(true)
        settings {
            put("http.enabled", false)
        }
    }

    node.close()
}

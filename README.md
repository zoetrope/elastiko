
**Work in progress**

# elastiko
Kotlin Asynchronous Elasticsearch Client.
It's a thin wrapper around the Java Elasticsearch client.

## Dependencies

 * kovenant
 * elasticsearch

## Version

|elastiko Version|Target Elasticsearch version|
|-------|---------------------|
|2.1.1-0|2.1.X|

## Install


## Usage

```kotlin
val client = transportClient(listOf(address("host1", 9300),address("host2", 9300))) {
    settings {
        put("cluster.name", "elasticsearch")
        put("client.transport.sniff", true)
    }
}

client.searchAsync("index1", "index2") {
    setTypes("type1", "type2")
    setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    setQuery(boolQuery {
        must(termQuery("field1", "test"))
        should(termQuery("field2", "sample"))
    })
    setPostFilter(rangeQuery("age"){
        from(12)
        to(18)
    })
    setFrom(0)
    setSize(60)
    setExplain(true)
} success {
    println("success: totalHits=${it.hits.totalHits}")
    it.hits.hits?.forEach {
        println(it.source)
    }
} fail {
    println("fail: ${it}")
}
```

## License

The MIT License
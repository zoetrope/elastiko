package elastiko

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.Client

public fun Client.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> {

    val deferred = deferred<SearchResponse, Exception>();
    prepareSearch(*indices)
            .apply { block() }
            .execute(DeferredActionListener(deferred))

    return deferred.promise
}


package elastiko

import nl.komponents.kovenant.Promise
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.Client


public fun Client.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> {
    return prepareSearch(*indices).apply { block() }.toPromise()
}


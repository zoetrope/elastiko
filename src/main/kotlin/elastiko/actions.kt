package elastiko

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.Client

public fun Client.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Throwable> {

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


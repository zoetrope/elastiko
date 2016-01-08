package elastiko

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.client.ClusterAdminClient

public fun ClusterAdminClient.healthAsync(vararg indices: String, block: ClusterHealthRequestBuilder.() -> Unit): Promise<ClusterHealthResponse, Exception> {

    val deferred = deferred<ClusterHealthResponse, Exception>();
    val builder = this.prepareHealth(*indices)
    builder.block()

    builder.execute(object : ActionListener<ClusterHealthResponse> {
        override fun onResponse(res: ClusterHealthResponse) {
            deferred.resolve(res)
        }

        override fun onFailure(e: Throwable) {
            deferred.reject(e as Exception)
        }
    })

    return deferred.promise
}

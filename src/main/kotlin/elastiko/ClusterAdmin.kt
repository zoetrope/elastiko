package elastiko

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.client.ClusterAdminClient

public fun ClusterAdminClient.healthAsync(vararg indices: String, block: ClusterHealthRequestBuilder.() -> Unit = fun() = Unit): Promise<ClusterHealthResponse, Exception> {

    val deferred = deferred<ClusterHealthResponse, Exception>();
    prepareHealth(*indices)
            .apply { block() }
            .execute(DeferredActionListener(deferred))

    return deferred.promise
}

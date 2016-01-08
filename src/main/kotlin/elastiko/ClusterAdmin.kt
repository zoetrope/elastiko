package elastiko

import nl.komponents.kovenant.Promise
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.client.ClusterAdminClient

public fun ClusterAdminClient.healthAsync(vararg indices: String, block: ClusterHealthRequestBuilder.() -> Unit = fun() = Unit): Promise<ClusterHealthResponse, Exception> {
    return prepareHealth(*indices).apply { block() }.toPromise()
}

package elastiko

import nl.komponents.kovenant.Promise
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequestBuilder
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsResponse
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequestBuilder
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryResponse
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesRequestBuilder
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesResponse
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryResponse
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequestBuilder
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse
import org.elasticsearch.action.admin.cluster.shards.ClusterSearchShardsRequestBuilder
import org.elasticsearch.action.admin.cluster.shards.ClusterSearchShardsResponse
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequestBuilder
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse
import org.elasticsearch.action.admin.cluster.state.ClusterStateRequestBuilder
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequestBuilder
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse
import org.elasticsearch.action.admin.cluster.tasks.PendingClusterTasksRequestBuilder
import org.elasticsearch.action.admin.cluster.tasks.PendingClusterTasksResponse
import org.elasticsearch.action.admin.cluster.validate.template.RenderSearchTemplateRequestBuilder
import org.elasticsearch.action.admin.cluster.validate.template.RenderSearchTemplateResponse
import org.elasticsearch.client.ClusterAdminClient

public fun ClusterAdminClient.clusterStatsAsync(block: ClusterStatsRequestBuilder.() -> Unit): Promise<ClusterStatsResponse, Exception> = prepareClusterStats().apply { block() }.toPromise()
public fun ClusterAdminClient.createSnapshotAsync(repository: String, name: String, block: CreateSnapshotRequestBuilder.() -> Unit): Promise<CreateSnapshotResponse, Exception> = prepareCreateSnapshot(repository, name).apply { block() }.toPromise()
public fun ClusterAdminClient.deleteRepositoryAsync(name: String, block: DeleteRepositoryRequestBuilder.() -> Unit): Promise<DeleteRepositoryResponse, Exception> = prepareDeleteRepository(name).apply { block() }.toPromise()
public fun ClusterAdminClient.deleteSnapshotAsync(repository: String, snapshot: String, block: DeleteSnapshotRequestBuilder.() -> Unit): Promise<DeleteSnapshotResponse, Exception> = prepareDeleteSnapshot(repository, snapshot).apply { block() }.toPromise()
public fun ClusterAdminClient.getRepositoriesAsync(vararg name: String, block: GetRepositoriesRequestBuilder.() -> Unit): Promise<GetRepositoriesResponse, Exception> = prepareGetRepositories(*name).apply { block() }.toPromise()
public fun ClusterAdminClient.getSnapshotsAsync(repository: String, block: GetSnapshotsRequestBuilder.() -> Unit): Promise<GetSnapshotsResponse, Exception> = prepareGetSnapshots(repository).apply { block() }.toPromise()
public fun ClusterAdminClient.healthAsync(vararg indices: String, block: ClusterHealthRequestBuilder.() -> Unit): Promise<ClusterHealthResponse, Exception> = prepareHealth(*indices).apply { block() }.toPromise()
public fun ClusterAdminClient.nodesHotThreadsAsync(vararg nodeIds: String, block: NodesHotThreadsRequestBuilder.() -> Unit): Promise<NodesHotThreadsResponse, Exception> = prepareNodesHotThreads(*nodeIds).apply { block() }.toPromise()
public fun ClusterAdminClient.nodesInfoAsync(vararg nodeIds: String, block: NodesInfoRequestBuilder.() -> Unit): Promise<NodesInfoResponse, Exception> = prepareNodesInfo(*nodeIds).apply { block() }.toPromise()
public fun ClusterAdminClient.nodesStatsAsync(vararg nodeIds: String, block: NodesStatsRequestBuilder.() -> Unit): Promise<NodesStatsResponse, Exception> = prepareNodesStats(*nodeIds).apply { block() }.toPromise()
public fun ClusterAdminClient.pendingClusterTasksAsync(block: PendingClusterTasksRequestBuilder.() -> Unit): Promise<PendingClusterTasksResponse, Exception> = preparePendingClusterTasks().apply { block() }.toPromise()
public fun ClusterAdminClient.putRepositoryAsync(name: String, block: PutRepositoryRequestBuilder.() -> Unit): Promise<PutRepositoryResponse, Exception> = preparePutRepository(name).apply { block() }.toPromise()
public fun ClusterAdminClient.renderSearchTemplateAsync(block: RenderSearchTemplateRequestBuilder.() -> Unit): Promise<RenderSearchTemplateResponse, Exception> = prepareRenderSearchTemplate().apply { block() }.toPromise()
public fun ClusterAdminClient.rerouteAsync(block: ClusterRerouteRequestBuilder.() -> Unit): Promise<ClusterRerouteResponse, Exception> = prepareReroute().apply { block() }.toPromise()
public fun ClusterAdminClient.restoreSnapshotAsync(repository: String, snapshot: String, block: RestoreSnapshotRequestBuilder.() -> Unit): Promise<RestoreSnapshotResponse, Exception> = prepareRestoreSnapshot(repository, snapshot).apply { block() }.toPromise()
public fun ClusterAdminClient.searchShardsAsync(block: ClusterSearchShardsRequestBuilder.() -> Unit): Promise<ClusterSearchShardsResponse, Exception> = prepareSearchShards().apply { block() }.toPromise()
public fun ClusterAdminClient.searchShardsAsync(vararg indices: String, block: ClusterSearchShardsRequestBuilder.() -> Unit): Promise<ClusterSearchShardsResponse, Exception> = prepareSearchShards(*indices).apply { block() }.toPromise()
public fun ClusterAdminClient.snapshotStatusAsync(repository: String, block: SnapshotsStatusRequestBuilder.() -> Unit): Promise<SnapshotsStatusResponse, Exception> = prepareSnapshotStatus(repository).apply { block() }.toPromise()
public fun ClusterAdminClient.snapshotStatusAsync(block: SnapshotsStatusRequestBuilder.() -> Unit): Promise<SnapshotsStatusResponse, Exception> = prepareSnapshotStatus().apply { block() }.toPromise()
public fun ClusterAdminClient.stateAsync(block: ClusterStateRequestBuilder.() -> Unit): Promise<ClusterStateResponse, Exception> = prepareState().apply { block() }.toPromise()
public fun ClusterAdminClient.updateSettingsAsync(block: ClusterUpdateSettingsRequestBuilder.() -> Unit): Promise<ClusterUpdateSettingsResponse, Exception> = prepareUpdateSettings().apply { block() }.toPromise()
public fun ClusterAdminClient.verifyRepositoryAsync(arg0: String, block: VerifyRepositoryRequestBuilder.() -> Unit): Promise<VerifyRepositoryResponse, Exception> = prepareVerifyRepository(arg0).apply { block() }.toPromise()
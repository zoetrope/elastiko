package elastiko

import nl.komponents.kovenant.Promise
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesResponse
import org.elasticsearch.action.admin.indices.alias.exists.AliasesExistRequestBuilder
import org.elasticsearch.action.admin.indices.alias.exists.AliasesExistResponse
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequestBuilder
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse
import org.elasticsearch.action.admin.indices.close.CloseIndexRequestBuilder
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequestBuilder
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse
import org.elasticsearch.action.admin.indices.flush.FlushRequestBuilder
import org.elasticsearch.action.admin.indices.flush.FlushResponse
import org.elasticsearch.action.admin.indices.flush.SyncedFlushRequestBuilder
import org.elasticsearch.action.admin.indices.flush.SyncedFlushResponse
import org.elasticsearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder
import org.elasticsearch.action.admin.indices.forcemerge.ForceMergeResponse
import org.elasticsearch.action.admin.indices.get.GetIndexRequestBuilder
import org.elasticsearch.action.admin.indices.get.GetIndexResponse
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse
import org.elasticsearch.action.admin.indices.open.OpenIndexRequestBuilder
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse
import org.elasticsearch.action.admin.indices.recovery.RecoveryRequestBuilder
import org.elasticsearch.action.admin.indices.recovery.RecoveryResponse
import org.elasticsearch.action.admin.indices.refresh.RefreshRequestBuilder
import org.elasticsearch.action.admin.indices.refresh.RefreshResponse
import org.elasticsearch.action.admin.indices.segments.IndicesSegmentResponse
import org.elasticsearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequestBuilder
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsResponse
import org.elasticsearch.action.admin.indices.shards.IndicesShardStoreRequestBuilder
import org.elasticsearch.action.admin.indices.shards.IndicesShardStoresResponse
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequestBuilder
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse
import org.elasticsearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder
import org.elasticsearch.action.admin.indices.template.delete.DeleteIndexTemplateResponse
import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesRequestBuilder
import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesResponse
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateResponse
import org.elasticsearch.action.admin.indices.upgrade.get.UpgradeStatusRequestBuilder
import org.elasticsearch.action.admin.indices.upgrade.get.UpgradeStatusResponse
import org.elasticsearch.action.admin.indices.upgrade.post.UpgradeRequestBuilder
import org.elasticsearch.action.admin.indices.upgrade.post.UpgradeResponse
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryResponse
import org.elasticsearch.action.admin.indices.warmer.delete.DeleteWarmerRequestBuilder
import org.elasticsearch.action.admin.indices.warmer.delete.DeleteWarmerResponse
import org.elasticsearch.action.admin.indices.warmer.get.GetWarmersRequestBuilder
import org.elasticsearch.action.admin.indices.warmer.get.GetWarmersResponse
import org.elasticsearch.action.admin.indices.warmer.put.PutWarmerRequestBuilder
import org.elasticsearch.action.admin.indices.warmer.put.PutWarmerResponse
import org.elasticsearch.client.IndicesAdminClient

public fun IndicesAdminClient.aliasesAsync(block: IndicesAliasesRequestBuilder.() -> Unit): Promise<IndicesAliasesResponse, Exception> = prepareAliases().apply { block() }.toPromise()
public fun IndicesAdminClient.aliasesExistAsync(vararg aliases: String, block: AliasesExistRequestBuilder.() -> Unit): Promise<AliasesExistResponse, Exception> = prepareAliasesExist(*aliases).apply { block() }.toPromise()
public fun IndicesAdminClient.analyzeAsync(text: String, block: AnalyzeRequestBuilder.() -> Unit): Promise<AnalyzeResponse, Exception> = prepareAnalyze(text).apply { block() }.toPromise()
public fun IndicesAdminClient.analyzeAsync(block: AnalyzeRequestBuilder.() -> Unit): Promise<AnalyzeResponse, Exception> = prepareAnalyze().apply { block() }.toPromise()
public fun IndicesAdminClient.analyzeAsync(index: String?, text: String, block: AnalyzeRequestBuilder.() -> Unit): Promise<AnalyzeResponse, Exception> = prepareAnalyze(index, text).apply { block() }.toPromise()
public fun IndicesAdminClient.clearCacheAsync(vararg indices: String, block: ClearIndicesCacheRequestBuilder.() -> Unit): Promise<ClearIndicesCacheResponse, Exception> = prepareClearCache(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.closeAsync(vararg indices: String, block: CloseIndexRequestBuilder.() -> Unit): Promise<CloseIndexResponse, Exception> = prepareClose(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.createAsync(index: String, block: CreateIndexRequestBuilder.() -> Unit): Promise<CreateIndexResponse, Exception> = prepareCreate(index).apply { block() }.toPromise()
public fun IndicesAdminClient.deleteAsync(vararg indices: String, block: DeleteIndexRequestBuilder.() -> Unit): Promise<DeleteIndexResponse, Exception> = prepareDelete(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.deleteTemplateAsync(name: String, block: DeleteIndexTemplateRequestBuilder.() -> Unit): Promise<DeleteIndexTemplateResponse, Exception> = prepareDeleteTemplate(name).apply { block() }.toPromise()
public fun IndicesAdminClient.deleteWarmerAsync(block: DeleteWarmerRequestBuilder.() -> Unit): Promise<DeleteWarmerResponse, Exception> = prepareDeleteWarmer().apply { block() }.toPromise()
public fun IndicesAdminClient.flushAsync(vararg indices: String, block: FlushRequestBuilder.() -> Unit): Promise<FlushResponse, Exception> = prepareFlush(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.forceMergeAsync(vararg indices: String, block: ForceMergeRequestBuilder.() -> Unit): Promise<ForceMergeResponse, Exception> = prepareForceMerge(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.getAliasesAsync(vararg aliases: String, block: GetAliasesRequestBuilder.() -> Unit): Promise<GetAliasesResponse, Exception> = prepareGetAliases(*aliases).apply { block() }.toPromise()
public fun IndicesAdminClient.getFieldMappingsAsync(vararg indices: String, block: GetFieldMappingsRequestBuilder.() -> Unit): Promise<GetFieldMappingsResponse, Exception> = prepareGetFieldMappings(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.getIndexAsync(block: GetIndexRequestBuilder.() -> Unit): Promise<GetIndexResponse, Exception> = prepareGetIndex().apply { block() }.toPromise()
public fun IndicesAdminClient.getMappingsAsync(vararg indices: String, block: GetMappingsRequestBuilder.() -> Unit): Promise<GetMappingsResponse, Exception> = prepareGetMappings(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.getSettingsAsync(vararg indices: String, block: GetSettingsRequestBuilder.() -> Unit): Promise<GetSettingsResponse, Exception> = prepareGetSettings(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.getTemplatesAsync(vararg name: String, block: GetIndexTemplatesRequestBuilder.() -> Unit): Promise<GetIndexTemplatesResponse, Exception> = prepareGetTemplates(*name).apply { block() }.toPromise()
public fun IndicesAdminClient.getWarmersAsync(vararg indices: String, block: GetWarmersRequestBuilder.() -> Unit): Promise<GetWarmersResponse, Exception> = prepareGetWarmers(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.openAsync(vararg indices: String, block: OpenIndexRequestBuilder.() -> Unit): Promise<OpenIndexResponse, Exception> = prepareOpen(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.putMappingAsync(vararg indices: String, block: PutMappingRequestBuilder.() -> Unit): Promise<PutMappingResponse, Exception> = preparePutMapping(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.putTemplateAsync(name: String, block: PutIndexTemplateRequestBuilder.() -> Unit): Promise<PutIndexTemplateResponse, Exception> = preparePutTemplate(name).apply { block() }.toPromise()
public fun IndicesAdminClient.putWarmerAsync(name: String, block: PutWarmerRequestBuilder.() -> Unit): Promise<PutWarmerResponse, Exception> = preparePutWarmer(name).apply { block() }.toPromise()
public fun IndicesAdminClient.recoveriesAsync(vararg indices: String, block: RecoveryRequestBuilder.() -> Unit): Promise<RecoveryResponse, Exception> = prepareRecoveries(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.refreshAsync(vararg indices: String, block: RefreshRequestBuilder.() -> Unit): Promise<RefreshResponse, Exception> = prepareRefresh(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.segmentsAsync(vararg indices: String, block: IndicesSegmentsRequestBuilder.() -> Unit): Promise<IndicesSegmentResponse, Exception> = prepareSegments(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.shardStoresAsync(vararg indices: String, block: IndicesShardStoreRequestBuilder.() -> Unit): Promise<IndicesShardStoresResponse, Exception> = prepareShardStores(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.syncedFlushAsync(vararg indices: String,block: SyncedFlushRequestBuilder.() -> Unit): Promise<SyncedFlushResponse, Exception> = prepareSyncedFlush(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.statsAsync(vararg indices: String, block: IndicesStatsRequestBuilder.() -> Unit): Promise<IndicesStatsResponse, Exception> = prepareStats(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.typesExistsAsync(vararg index: String, block: TypesExistsRequestBuilder.() -> Unit): Promise<TypesExistsResponse, Exception> = prepareTypesExists(*index).apply { block() }.toPromise()
public fun IndicesAdminClient.updateSettingsAsync(vararg indices: String, block: UpdateSettingsRequestBuilder.() -> Unit): Promise<UpdateSettingsResponse, Exception> = prepareUpdateSettings(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.upgradeAsync(vararg indices: String, block: UpgradeRequestBuilder.() -> Unit): Promise<UpgradeResponse, Exception> = prepareUpgrade(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.upgradeStatusAsync(vararg indices: String, block: UpgradeStatusRequestBuilder.() -> Unit): Promise<UpgradeStatusResponse, Exception> = prepareUpgradeStatus(*indices).apply { block() }.toPromise()
public fun IndicesAdminClient.validateQueryAsync(vararg indices: String, block: ValidateQueryRequestBuilder.() -> Unit): Promise<ValidateQueryResponse, Exception> = prepareValidateQuery(*indices).apply { block() }.toPromise()

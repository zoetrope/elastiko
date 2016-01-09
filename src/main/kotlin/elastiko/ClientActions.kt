package elastiko

import nl.komponents.kovenant.Promise
import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.action.bulk.BulkResponse
import org.elasticsearch.action.delete.DeleteRequestBuilder
import org.elasticsearch.action.delete.DeleteResponse
import org.elasticsearch.action.explain.ExplainRequestBuilder
import org.elasticsearch.action.explain.ExplainResponse
import org.elasticsearch.action.fieldstats.FieldStatsRequestBuilder
import org.elasticsearch.action.fieldstats.FieldStatsResponse
import org.elasticsearch.action.get.GetRequestBuilder
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.get.MultiGetRequestBuilder
import org.elasticsearch.action.get.MultiGetResponse
import org.elasticsearch.action.index.IndexRequestBuilder
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.indexedscripts.delete.DeleteIndexedScriptRequestBuilder
import org.elasticsearch.action.indexedscripts.delete.DeleteIndexedScriptResponse
import org.elasticsearch.action.indexedscripts.get.GetIndexedScriptRequestBuilder
import org.elasticsearch.action.indexedscripts.get.GetIndexedScriptResponse
import org.elasticsearch.action.indexedscripts.put.PutIndexedScriptRequestBuilder
import org.elasticsearch.action.indexedscripts.put.PutIndexedScriptResponse
import org.elasticsearch.action.percolate.MultiPercolateRequestBuilder
import org.elasticsearch.action.percolate.MultiPercolateResponse
import org.elasticsearch.action.percolate.PercolateRequestBuilder
import org.elasticsearch.action.percolate.PercolateResponse
import org.elasticsearch.action.search.*
import org.elasticsearch.action.suggest.SuggestRequestBuilder
import org.elasticsearch.action.suggest.SuggestResponse
import org.elasticsearch.action.termvectors.MultiTermVectorsRequestBuilder
import org.elasticsearch.action.termvectors.MultiTermVectorsResponse
import org.elasticsearch.action.termvectors.TermVectorsRequestBuilder
import org.elasticsearch.action.termvectors.TermVectorsResponse
import org.elasticsearch.action.update.UpdateRequestBuilder
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.Client

public fun Client.bulkAsync(block: BulkRequestBuilder.() -> Unit): Promise<BulkResponse, Exception> = prepareBulk().apply { block() }.toPromise()
public fun Client.clearScrollAsync(block: ClearScrollRequestBuilder.() -> Unit): Promise<ClearScrollResponse, Exception> = prepareClearScroll().apply { block() }.toPromise()
public fun Client.deleteAsync(block: DeleteRequestBuilder.() -> Unit): Promise<DeleteResponse, Exception> = prepareDelete().apply { block() }.toPromise()
public fun Client.deleteAsync(index: String, type: String, id: String, block: DeleteRequestBuilder.() -> Unit): Promise<DeleteResponse, Exception> = prepareDelete(index, type, id).apply { block() }.toPromise()
public fun Client.deleteIndexedScriptAsync(block: DeleteIndexedScriptRequestBuilder.() -> Unit): Promise<DeleteIndexedScriptResponse, Exception> = prepareDeleteIndexedScript().apply { block() }.toPromise()
public fun Client.deleteIndexedScriptAsync(scriptLang: String?, id: String, block: DeleteIndexedScriptRequestBuilder.() -> Unit): Promise<DeleteIndexedScriptResponse, Exception> = prepareDeleteIndexedScript(scriptLang, id).apply { block() }.toPromise()
//public fun Client.executeAsync(action: Action<Request, Response, RequestBuilder>, block: ExecuteRequestBuilder.() -> Unit): Promise<ExecuteResponse, Exception> = prepareExecute(action).apply { block() }.toPromise()
public fun Client.explainAsync(index: String, type: String, id: String, block: ExplainRequestBuilder.() -> Unit): Promise<ExplainResponse, Exception> = prepareExplain(index, type, id).apply { block() }.toPromise()

public fun Client.fieldStatsAsync(block: FieldStatsRequestBuilder.() -> Unit): Promise<FieldStatsResponse, Exception> = prepareFieldStats().apply { block() }.toPromise()
public fun Client.getAsync(index: String, type: String?, id: String, block: GetRequestBuilder.() -> Unit): Promise<GetResponse, Exception> = prepareGet(index, type, id).apply { block() }.toPromise()
public fun Client.getAsync(block: GetRequestBuilder.() -> Unit): Promise<GetResponse, Exception> = prepareGet().apply { block() }.toPromise()
public fun Client.getIndexedScriptAsync(block: GetIndexedScriptRequestBuilder.() -> Unit): Promise<GetIndexedScriptResponse, Exception> = prepareGetIndexedScript().apply { block() }.toPromise()
public fun Client.getIndexedScriptAsync(scriptLang: String?, id: String, block: GetIndexedScriptRequestBuilder.() -> Unit): Promise<GetIndexedScriptResponse, Exception> = prepareGetIndexedScript(scriptLang, id).apply { block() }.toPromise()
public fun Client.indexAsync(block: IndexRequestBuilder.() -> Unit): Promise<IndexResponse, Exception> = prepareIndex().apply { block() }.toPromise()
public fun Client.indexAsync(index: String, type: String, id: String?, block: IndexRequestBuilder.() -> Unit): Promise<IndexResponse, Exception> = prepareIndex(index, type, id).apply { block() }.toPromise()
public fun Client.indexAsync(index: String, type: String, block: IndexRequestBuilder.() -> Unit): Promise<IndexResponse, Exception> = prepareIndex(index, type).apply { block() }.toPromise()
public fun Client.multiGetAsync(block: MultiGetRequestBuilder.() -> Unit): Promise<MultiGetResponse, Exception> = prepareMultiGet().apply { block() }.toPromise()
public fun Client.multiPercolateAsync(block: MultiPercolateRequestBuilder.() -> Unit): Promise<MultiPercolateResponse, Exception> = prepareMultiPercolate().apply { block() }.toPromise()
public fun Client.multiSearchAsync(block: MultiSearchRequestBuilder.() -> Unit): Promise<MultiSearchResponse, Exception> = prepareMultiSearch().apply { block() }.toPromise()
public fun Client.multiTermVectorsAsync(block: MultiTermVectorsRequestBuilder.() -> Unit): Promise<MultiTermVectorsResponse, Exception> = prepareMultiTermVectors().apply { block() }.toPromise()
public fun Client.percolateAsync(block: PercolateRequestBuilder.() -> Unit): Promise<PercolateResponse, Exception> = preparePercolate().apply { block() }.toPromise()
public fun Client.putIndexedScriptAsync(block: PutIndexedScriptRequestBuilder.() -> Unit): Promise<PutIndexedScriptResponse, Exception> = preparePutIndexedScript().apply { block() }.toPromise()
public fun Client.putIndexedScriptAsync(scriptLang: String?, id: String, source: String, block: PutIndexedScriptRequestBuilder.() -> Unit): Promise<PutIndexedScriptResponse, Exception> = preparePutIndexedScript(scriptLang, id, source).apply { block() }.toPromise()
public fun Client.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> = prepareSearch(*indices).apply { block() }.toPromise()
public fun Client.searchScrollAsync(scrollId: String, block: SearchScrollRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> = prepareSearchScroll(scrollId).apply { block() }.toPromise()
public fun Client.suggestAsync(vararg indices: String, block: SuggestRequestBuilder.() -> Unit): Promise<SuggestResponse, Exception> = prepareSuggest(*indices).apply { block() }.toPromise()
public fun Client.termVectorsAsync(index: String, type: String, id: String, block: TermVectorsRequestBuilder.() -> Unit): Promise<TermVectorsResponse, Exception> = prepareTermVectors(index, type, id).apply { block() }.toPromise()
public fun Client.termVectorsAsync(block: TermVectorsRequestBuilder.() -> Unit): Promise<TermVectorsResponse, Exception> = prepareTermVectors().apply { block() }.toPromise()
public fun Client.updateAsync(block: UpdateRequestBuilder.() -> Unit): Promise<UpdateResponse, Exception> = prepareUpdate().apply { block() }.toPromise()
public fun Client.updateAsync(index: String, type: String, id: String, block: UpdateRequestBuilder.() -> Unit): Promise<UpdateResponse, Exception> = prepareUpdate(index, type, id).apply { block() }.toPromise()

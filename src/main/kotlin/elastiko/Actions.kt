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

public fun Client.bulkAsync(block: BulkRequestBuilder.() -> Unit): Promise<BulkResponse, Exception> {
    return prepareBulk().apply { block() }.toPromise()
}

public fun Client.clearScrollAsync(block: ClearScrollRequestBuilder.() -> Unit): Promise<ClearScrollResponse, Exception> {
    return prepareClearScroll().apply { block() }.toPromise()
}

public fun Client.deleteAsync(block: DeleteRequestBuilder.() -> Unit): Promise<DeleteResponse, Exception> {
    return prepareDelete().apply { block() }.toPromise()
}

public fun Client.deleteIndexedScriptAsync(block: DeleteIndexedScriptRequestBuilder.() -> Unit): Promise<DeleteIndexedScriptResponse, Exception> {
    return prepareDeleteIndexedScript().apply { block() }.toPromise()
}

public fun Client.explainAsync(index: String, type: String, id: String, block: ExplainRequestBuilder.() -> Unit): Promise<ExplainResponse, Exception> {
    return prepareExplain(index, type, id).apply { block() }.toPromise()
}

public fun Client.fieldStatsAsync(block: FieldStatsRequestBuilder.() -> Unit): Promise<FieldStatsResponse, Exception> {
    return prepareFieldStats().apply { block() }.toPromise()
}

public fun Client.getAsync(block: GetRequestBuilder.() -> Unit): Promise<GetResponse, Exception> {
    return prepareGet().apply { block() }.toPromise()
}

public fun Client.getIndexedScriptAsync(block: GetIndexedScriptRequestBuilder.() -> Unit): Promise<GetIndexedScriptResponse, Exception> {
    return prepareGetIndexedScript().apply { block() }.toPromise()
}

public fun Client.indexAsync(block: IndexRequestBuilder.() -> Unit): Promise<IndexResponse, Exception> {
    return prepareIndex().apply { block() }.toPromise()
}

public fun Client.multiGetAsync(block: MultiGetRequestBuilder.() -> Unit): Promise<MultiGetResponse, Exception> {
    return prepareMultiGet().apply { block() }.toPromise()
}

public fun Client.multiPercolateAsync(block: MultiPercolateRequestBuilder.() -> Unit): Promise<MultiPercolateResponse, Exception> {
    return prepareMultiPercolate().apply { block() }.toPromise()
}

public fun Client.multiSearchAsync(block: MultiSearchRequestBuilder.() -> Unit): Promise<MultiSearchResponse, Exception> {
    return prepareMultiSearch().apply { block() }.toPromise()
}

public fun Client.multiTermVectorsAsync(block: MultiTermVectorsRequestBuilder.() -> Unit): Promise<MultiTermVectorsResponse, Exception> {
    return prepareMultiTermVectors().apply { block() }.toPromise()
}

public fun Client.percolateAsync(block: PercolateRequestBuilder.() -> Unit): Promise<PercolateResponse, Exception> {
    return preparePercolate().apply { block() }.toPromise()
}

public fun Client.putIndexedScriptAsync(block: PutIndexedScriptRequestBuilder.() -> Unit): Promise<PutIndexedScriptResponse, Exception> {
    return preparePutIndexedScript().apply { block() }.toPromise()
}

public fun Client.searchAsync(vararg indices: String, block: SearchRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> {
    return prepareSearch(*indices).apply { block() }.toPromise()
}

public fun Client.searchScrollAsync(scrollId: String, block: SearchScrollRequestBuilder.() -> Unit): Promise<SearchResponse, Exception> {
    return prepareSearchScroll(scrollId).apply { block() }.toPromise()
}

public fun Client.suggestAsync(block: SuggestRequestBuilder.() -> Unit): Promise<SuggestResponse, Exception> {
    return prepareSuggest().apply { block() }.toPromise()
}

public fun Client.termVectorsAsync(block: TermVectorsRequestBuilder.() -> Unit): Promise<TermVectorsResponse, Exception> {
    return prepareTermVectors().apply { block() }.toPromise()
}

public fun Client.updateAsync(block: UpdateRequestBuilder.() -> Unit): Promise<UpdateResponse, Exception> {
    return prepareUpdate().apply { block() }.toPromise()
}


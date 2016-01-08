package elastiko

import org.elasticsearch.index.query.BoolQueryBuilder
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.RangeQueryBuilder

public fun bool(block: BoolQueryBuilder.() -> Unit): QueryBuilder = QueryBuilders.boolQuery().apply { block() }

public fun <T> term(name: String, value: T): QueryBuilder = QueryBuilders.termQuery(name, value)

public fun range(name: String, block: RangeQueryBuilder.() -> Unit): QueryBuilder = QueryBuilders.rangeQuery(name).apply { block() }

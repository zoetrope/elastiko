package elastiko

import org.elasticsearch.search.aggregations.AbstractAggregationBuilder
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.aggregations.metrics.avg.AvgBuilder

public fun avg(name: String, block: AvgBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.avg(name).apply { block() }


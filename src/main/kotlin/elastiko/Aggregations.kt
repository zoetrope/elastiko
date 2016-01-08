package elastiko

import org.elasticsearch.search.aggregations.AbstractAggregationBuilder
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.aggregations.bucket.children.ChildrenBuilder
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder
import org.elasticsearch.search.aggregations.bucket.filters.FiltersAggregationBuilder
import org.elasticsearch.search.aggregations.bucket.geogrid.GeoHashGridBuilder
import org.elasticsearch.search.aggregations.bucket.global.GlobalBuilder
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramBuilder
import org.elasticsearch.search.aggregations.bucket.histogram.HistogramBuilder
import org.elasticsearch.search.aggregations.bucket.missing.MissingBuilder
import org.elasticsearch.search.aggregations.bucket.nested.NestedBuilder
import org.elasticsearch.search.aggregations.bucket.nested.ReverseNestedBuilder
import org.elasticsearch.search.aggregations.bucket.range.RangeBuilder
import org.elasticsearch.search.aggregations.bucket.range.date.DateRangeBuilder
import org.elasticsearch.search.aggregations.bucket.range.geodistance.GeoDistanceBuilder
import org.elasticsearch.search.aggregations.bucket.range.ipv4.IPv4RangeBuilder
import org.elasticsearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder
import org.elasticsearch.search.aggregations.bucket.significant.SignificantTermsBuilder
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder
import org.elasticsearch.search.aggregations.metrics.avg.AvgBuilder
import org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityBuilder
import org.elasticsearch.search.aggregations.metrics.geobounds.GeoBoundsBuilder
import org.elasticsearch.search.aggregations.metrics.geocentroid.GeoCentroidBuilder
import org.elasticsearch.search.aggregations.metrics.max.MaxBuilder
import org.elasticsearch.search.aggregations.metrics.min.MinBuilder
import org.elasticsearch.search.aggregations.metrics.percentiles.PercentileRanksBuilder
import org.elasticsearch.search.aggregations.metrics.percentiles.PercentilesBuilder
import org.elasticsearch.search.aggregations.metrics.scripted.ScriptedMetricBuilder
import org.elasticsearch.search.aggregations.metrics.stats.StatsBuilder
import org.elasticsearch.search.aggregations.metrics.stats.extended.ExtendedStatsBuilder
import org.elasticsearch.search.aggregations.metrics.sum.SumBuilder
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsBuilder
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountBuilder

public fun avg(name: String, block: AvgBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.avg(name).apply { block() }
public fun cardinality(name: String, block: CardinalityBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.cardinality(name).apply { block() }
public fun children(name: String, block: ChildrenBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.children(name).apply { block() }
public fun count(name: String, block: ValueCountBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.count(name).apply { block() }
public fun dateHistogram(name: String, block: DateHistogramBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.dateHistogram(name).apply { block() }
public fun dateRange(name: String, block: DateRangeBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.dateRange(name).apply { block() }
public fun extendedStats(name: String, block: ExtendedStatsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.extendedStats(name).apply { block() }
public fun filter(name: String, block: FilterAggregationBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.filter(name).apply { block() }
public fun filters(name: String, block: FiltersAggregationBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.filters(name).apply { block() }
public fun geoBounds(name: String, block: GeoBoundsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.geoBounds(name).apply { block() }
public fun geoCentroid(name: String, block: GeoCentroidBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.geoCentroid(name).apply { block() }
public fun geoDistance(name: String, block: GeoDistanceBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.geoDistance(name).apply { block() }
public fun geohashGrid(name: String, block: GeoHashGridBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.geohashGrid(name).apply { block() }
public fun global(name: String, block: GlobalBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.global(name).apply { block() }
public fun histogram(name: String, block: HistogramBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.histogram(name).apply { block() }
public fun ipRange(name: String, block: IPv4RangeBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.ipRange(name).apply { block() }
public fun max(name: String, block: MaxBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.max(name).apply { block() }
public fun min(name: String, block: MinBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.min(name).apply { block() }
public fun missing(name: String, block: MissingBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.missing(name).apply { block() }
public fun nested(name: String, block: NestedBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.nested(name).apply { block() }
public fun percentileRanks(name: String, block: PercentileRanksBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.percentileRanks(name).apply { block() }
public fun percentiles(name: String, block: PercentilesBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.percentiles(name).apply { block() }
public fun range(name: String, block: RangeBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.range(name).apply { block() }
public fun reverseNested(name: String, block: ReverseNestedBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.reverseNested(name).apply { block() }
public fun sampler(name: String, block: SamplerAggregationBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.sampler(name).apply { block() }
public fun scriptedMetric(name: String, block: ScriptedMetricBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.scriptedMetric(name).apply { block() }
public fun significantTerms(name: String, block: SignificantTermsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.significantTerms(name).apply { block() }
public fun stats(name: String, block: StatsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.stats(name).apply { block() }
public fun sum(name: String, block: SumBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.sum(name).apply { block() }
public fun terms(name: String, block: TermsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.terms(name).apply { block() }
public fun topHits(name: String, block: TopHitsBuilder.() -> Unit = fun() = Unit): AbstractAggregationBuilder = AggregationBuilders.topHits(name).apply { block() }
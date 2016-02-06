package elastiko

import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.geo.GeoPoint
import org.elasticsearch.common.geo.ShapeRelation
import org.elasticsearch.common.geo.builders.ShapeBuilder
import org.elasticsearch.index.query.*
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilder
import org.elasticsearch.script.Script
import org.elasticsearch.script.ScriptService
import org.elasticsearch.script.Template

public fun boolQuery(block: BoolQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.boolQuery().apply { block() }
public fun boostingQuery(block: BoostingQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.boostingQuery().apply { block() }
public fun commonTermsQuery(name: String, text: Any, block: CommonTermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.commonTermsQuery(name, text).apply { block() }
public fun constantScoreQuery(queryBuilder: QueryBuilder, block: ConstantScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.constantScoreQuery(queryBuilder).apply { block() }
public fun disMaxQuery(block: DisMaxQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.disMaxQuery().apply { block() }
public fun existsQuery(name: String, block: ExistsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.existsQuery(name).apply { block() }
public fun fieldMaskingSpanQuery(query: SpanQueryBuilder, field: String, block: FieldMaskingSpanQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fieldMaskingSpanQuery(query, field).apply { block() }
public fun functionScoreQuery(block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery().apply { block() }
public fun functionScoreQuery(function: ScoreFunctionBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(function).apply { block() }
public fun functionScoreQuery(queryBuilder: QueryBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder).apply { block() }
public fun functionScoreQuery(queryBuilder: QueryBuilder, function: ScoreFunctionBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder, function).apply { block() }
public fun fuzzyQuery(name: String, value: Any, block: FuzzyQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fuzzyQuery(name, value).apply { block() }
public fun fuzzyQuery(name: String, value: String, block: FuzzyQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fuzzyQuery(name, value).apply { block() }
public fun geoBoundingBoxQuery(name: String, block: GeoBoundingBoxQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoBoundingBoxQuery(name).apply { block() }
public fun geoDisjointQuery(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDisjointQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoDisjointQuery(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDisjointQuery(name, shape).apply { block() }
public fun geoDistanceQuery(name: String, block: GeoDistanceQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDistanceQuery(name).apply { block() }
public fun geoDistanceRangeQuery(name: String, block: GeoDistanceRangeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDistanceRangeQuery(name).apply { block() }
public fun geoHashCellQuery(name: String, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name).apply { block() }
public fun geoHashCellQuery(name: String, geohash: String, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, geohash).apply { block() }
public fun geoHashCellQuery(name: String, geohash: String, neighbors: Boolean, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, geohash, neighbors).apply { block() }
public fun geoHashCellQuery(name: String, point: GeoPoint, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, point).apply { block() }
public fun geoIntersectionQuery(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoIntersectionQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoIntersectionQuery(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoIntersectionQuery(name, shape).apply { block() }
public fun geoPolygonQuery(name: String, block: GeoPolygonQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoPolygonQuery(name).apply { block() }
public fun geoShapeQuery(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoShapeQuery(name: String, indexedShapeId: String, indexedShapeType: String, relation: ShapeRelation, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, indexedShapeId, indexedShapeType, relation).apply { block() }
public fun geoShapeQuery(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, shape).apply { block() }
public fun geoShapeQuery(name: String, shape: ShapeBuilder, relation: ShapeRelation, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, shape, relation).apply { block() }
public fun geoWithinQuery(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoWithinQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoWithinQuery(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoWithinQuery(name, shape).apply { block() }
public fun hasChildQuery(type: String, query: QueryBuilder, block: HasChildQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.hasChildQuery(type, query).apply { block() }
public fun hasParentQuery(type: String, query: QueryBuilder, block: HasParentQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.hasParentQuery(type, query).apply { block() }
public fun idsQuery(vararg types: String?, block: IdsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.idsQuery(*types).apply { block() }
public fun indicesQuery(queryBuilder: QueryBuilder, vararg indices: String, block: IndicesQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.indicesQuery(queryBuilder, *indices).apply { block() }
public fun matchQuery(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchQuery(name, text).apply { block() }
public fun matchAllQuery(block: MatchAllQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchAllQuery().apply { block() }
public fun matchPhraseQuery(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchPhraseQuery(name, text).apply { block() }
public fun matchPhrasePrefixQuery(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchPhrasePrefixQuery(name, text).apply { block() }
public fun moreLikeThisQuery(block: MoreLikeThisQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.moreLikeThisQuery().apply { block() }
public fun moreLikeThisQuery(vararg fields: String, block: MoreLikeThisQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.moreLikeThisQuery(*fields).apply { block() }
public fun multiMatchQuery(name: Any, vararg fieldNames: String, block: MultiMatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.multiMatchQuery(name, *fieldNames).apply { block() }
public fun nestedQuery(path: String, query: QueryBuilder, block: NestedQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.nestedQuery(path, query).apply { block() }
public fun prefixQuery(name: String, prefix: String, block: PrefixQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.prefixQuery(name, prefix).apply { block() }
public fun queryStringQuery(queryString: String, block: QueryStringQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.queryStringQuery(queryString).apply { block() }
public fun rangeQuery(name: String, block: RangeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.rangeQuery(name).apply { block() }
public fun regexpQuery(name: String, regexp: String, block: RegexpQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.regexpQuery(name, regexp).apply { block() }
public fun scriptQuery(script: Script, block: ScriptQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.scriptQuery(script).apply { block() }
public fun simpleStringQuery(queryString: String, block: SimpleQueryStringBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.simpleQueryStringQuery(queryString).apply { block() }
public fun spanContainingQuery(block: SpanContainingQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanContainingQuery().apply { block() }
public fun spanFirstQuery(match: SpanQueryBuilder, end: Int, block: SpanFirstQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanFirstQuery(match, end).apply { block() }
public fun spanNearQuery(block: SpanNearQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanNearQuery().apply { block() }
public fun spanNotQuery(block: SpanNotQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanNotQuery().apply { block() }
public fun spanOrQuery(block: SpanOrQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanOrQuery().apply { block() }
public fun spanTermQuery(name: String, value: Double, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTermQuery(name: String, value: Float, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTermQuery(name: String, value: Int, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTermQuery(name: String, value: Long, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTermQuery(name: String, value: String, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanWithinQuery(block: SpanWithinQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanWithinQuery().apply { block() }
public fun templateQuery(template: String, templateType: ScriptService.ScriptType, vars: Map<String, Any>, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template, templateType, vars).apply { block() }
public fun templateQuery(template: String, vars: Map<String, Any>, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template, vars).apply { block() }
public fun templateQuery(template: Template, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template).apply { block() }
public fun termQuery(name: String, value: Any, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: Boolean, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: Double, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: Float, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: Int, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: Long, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termQuery(name: String, value: String, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun termsQuery(name: String, vararg values: Any, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, vararg values: String, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, values: Collection<*>, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, values: DoubleArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, values: FloatArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, values: IntArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsQuery(name: String, values: LongArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun termsLookupQuery(name: String, block: TermsLookupQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsLookupQuery(name).apply { block() }
public fun typeQuery(type: String, block: TypeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.typeQuery(type).apply { block() }
public fun wildcardQuery(name: String, query: String, block: WildcardQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wildcardQuery(name, query).apply { block() }
public fun wrapperQuery(source: ByteArray, offset: Int, length: Int, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source, offset, length).apply { block() }
public fun wrapperQuery(source: BytesReference, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source).apply { block() }
public fun wrapperQuery(source: String, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source).apply { block() }


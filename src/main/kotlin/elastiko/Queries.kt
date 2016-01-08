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

public fun prefix(name: String, prefix: String, block: PrefixQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.prefixQuery(name, prefix).apply { block() }
public fun geoWithin(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoWithinQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoWithin(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoWithinQuery(name, shape).apply { block() }
public fun range(name: String, block: RangeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.rangeQuery(name).apply { block() }
public fun missing(name: String, block: MissingQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.missingQuery(name).apply { block() }
public fun fieldMaskingSpan(query: SpanQueryBuilder, field: String, block: FieldMaskingSpanQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fieldMaskingSpanQuery(query, field).apply { block() }
public fun disMax(block: DisMaxQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.disMaxQuery().apply { block() }
public fun spanOr(block: SpanOrQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanOrQuery().apply { block() }
public fun simpleString(queryString: String, block: SimpleQueryStringBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.simpleQueryStringQuery(queryString).apply { block() }
public fun multiMatch(name: Any, fieldNames: Array<out String>, block: MultiMatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.multiMatchQuery(name, *fieldNames).apply { block() }
public fun nested(path: String, query: QueryBuilder, block: NestedQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.nestedQuery(path, query).apply { block() }
public fun regexp(name: String, regexp: String, block: RegexpQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.regexpQuery(name, regexp).apply { block() }
public fun termsLookup(name: String, block: TermsLookupQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsLookupQuery(name).apply { block() }
public fun indices(queryBuilder: QueryBuilder, indices: Array<out String>, block: IndicesQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.indicesQuery(queryBuilder, *indices).apply { block() }
public fun fuzzy(name: String, value: Any, block: FuzzyQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fuzzyQuery(name, value).apply { block() }
public fun fuzzy(name: String, value: String, block: FuzzyQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.fuzzyQuery(name, value).apply { block() }
public fun geoDistance(name: String, block: GeoDistanceQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDistanceQuery(name).apply { block() }
public fun terms(name: String, values: DoubleArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: FloatArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: Array<out Any>, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: Collection<*>, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: Array<out String>, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: IntArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun terms(name: String, values: LongArray, block: TermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termsQuery(name, values).apply { block() }
public fun commonTerms(name: String, text: Any, block: CommonTermsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.commonTermsQuery(name, text).apply { block() }
public fun bool(block: BoolQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.boolQuery().apply { block() }
public fun spanContaining(block: SpanContainingQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanContainingQuery().apply { block() }
public fun term(name: String, value: Float, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: Double, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: Boolean, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: Any, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: String, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: Int, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun term(name: String, value: Long, block: TermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.termQuery(name, value).apply { block() }
public fun constantScore(queryBuilder: QueryBuilder, block: ConstantScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.constantScoreQuery(queryBuilder).apply { block() }
public fun wildcard(name: String, query: String, block: WildcardQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wildcardQuery(name, query).apply { block() }
public fun queryString(queryString: String, block: QueryStringQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.queryStringQuery(queryString).apply { block() }
public fun spanNot(block: SpanNotQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanNotQuery().apply { block() }
public fun geoShape(name: String, shape: ShapeBuilder, relation: ShapeRelation, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, shape, relation).apply { block() }
public fun geoShape(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoShape(name: String, indexedShapeId: String, indexedShapeType: String, relation: ShapeRelation, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, indexedShapeId, indexedShapeType, relation).apply { block() }
public fun geoShape(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoShapeQuery(name, shape).apply { block() }
public fun geoIntersection(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoIntersectionQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoIntersection(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoIntersectionQuery(name, shape).apply { block() }
public fun geoDisjoint(name: String, indexedShapeId: String, indexedShapeType: String, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDisjointQuery(name, indexedShapeId, indexedShapeType).apply { block() }
public fun geoDisjoint(name: String, shape: ShapeBuilder, block: GeoShapeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDisjointQuery(name, shape).apply { block() }
public fun exists(name: String, block: ExistsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.existsQuery(name).apply { block() }
public fun moreLikeThis(block: MoreLikeThisQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.moreLikeThisQuery().apply { block() }
public fun moreLikeThis(fields: Array<out String>, block: MoreLikeThisQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.moreLikeThisQuery(*fields).apply { block() }
public fun type(type: String, block: TypeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.typeQuery(type).apply { block() }
public fun geoPolygon(name: String, block: GeoPolygonQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoPolygonQuery(name).apply { block() }
public fun matchAll(block: MatchAllQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchAllQuery().apply { block() }
public fun geoDistanceRange(name: String, block: GeoDistanceRangeQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoDistanceRangeQuery(name).apply { block() }
public fun matchPhrasePrefix(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchPhrasePrefixQuery(name, text).apply { block() }
public fun template(template: Template, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template).apply { block() }
public fun template(template: String, vars: Map<String, Any>, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template, vars).apply { block() }
public fun template(template: String, templateType: ScriptService.ScriptType, vars: Map<String, Any>, block: TemplateQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.templateQuery(template, templateType, vars).apply { block() }
public fun script(script: Script, block: ScriptQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.scriptQuery(script).apply { block() }
public fun spanWithin(block: SpanWithinQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanWithinQuery().apply { block() }
public fun geoBoundingBox(name: String, block: GeoBoundingBoxQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoBoundingBoxQuery(name).apply { block() }
public fun spanFirst(match: SpanQueryBuilder, end: Int, block: SpanFirstQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanFirstQuery(match, end).apply { block() }
public fun wrapper(source: ByteArray, offset: Int, length: Int, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source, offset, length).apply { block() }
public fun wrapper(source: BytesReference, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source).apply { block() }
public fun wrapper(source: String, block: WrapperQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.wrapperQuery(source).apply { block() }
public fun functionScore(queryBuilder: QueryBuilder, function: ScoreFunctionBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder, function).apply { block() }
public fun functionScore(function: ScoreFunctionBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(function).apply { block() }
public fun functionScore(block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery().apply { block() }
public fun functionScore(queryBuilder: QueryBuilder, block: FunctionScoreQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder).apply { block() }
public fun ids(types: Array<out String?>, block: IdsQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.idsQuery(*types).apply { block() }
public fun matchPhrase(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchPhraseQuery(name, text).apply { block() }
public fun spanTerm(name: String, value: Long, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTerm(name: String, value: Float, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTerm(name: String, value: Double, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTerm(name: String, value: Int, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun spanTerm(name: String, value: String, block: SpanTermQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanTermQuery(name, value).apply { block() }
public fun hasParent(type: String, query: QueryBuilder, block: HasParentQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.hasParentQuery(type, query).apply { block() }
public fun geoHashCell(name: String, geohash: String, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, geohash).apply { block() }
public fun geoHashCell(name: String, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name).apply { block() }
public fun geoHashCell(name: String, point: GeoPoint, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, point).apply { block() }
public fun geoHashCell(name: String, geohash: String, neighbors: Boolean, block: GeohashCellQuery.Builder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.geoHashCellQuery(name, geohash, neighbors).apply { block() }
public fun hasChild(type: String, query: QueryBuilder, block: HasChildQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.hasChildQuery(type, query).apply { block() }
public fun spanNear(block: SpanNearQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.spanNearQuery().apply { block() }
public fun match(name: String, text: Any, block: MatchQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.matchQuery(name, text).apply { block() }
public fun boosting(block: BoostingQueryBuilder.() -> Unit = fun() = Unit): QueryBuilder = QueryBuilders.boostingQuery().apply { block() }

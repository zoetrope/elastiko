package elastiko

import nl.komponents.kovenant.Deferred
import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.deferred
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ActionRequest
import org.elasticsearch.action.ActionRequestBuilder
import org.elasticsearch.action.ActionResponse

public class WrappedThrowableException(cause: Throwable) : Exception(cause.message, cause)

class DeferredActionListener<T>(deferred: Deferred<T, Exception>) : ActionListener<T> {

    var deferred: Deferred<T, Exception> = deferred

    override fun onResponse(res: T) {
        deferred.resolve(res)
    }

    override fun onFailure(e: Throwable) {
        when (e) {
            is Exception -> deferred.reject(e)
            else -> deferred.reject(WrappedThrowableException(e))
        }
    }
}

public fun <TRequest : ActionRequest<*>, TResponse : ActionResponse, TRequestBuilder : ActionRequestBuilder<TRequest, TResponse, TRequestBuilder>> ActionRequestBuilder<TRequest, TResponse, TRequestBuilder>.toPromise(): Promise<TResponse, Exception> {
    val deferred = deferred<TResponse, Exception>()
    this.execute(DeferredActionListener(deferred))
    return deferred.promise
}


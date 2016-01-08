package elastiko

import nl.komponents.kovenant.Deferred
import org.elasticsearch.action.ActionListener

class DeferredActionListener<T>(deferred: Deferred<T, Exception>) : ActionListener<T> {

    var deferred: Deferred<T, Exception> = deferred

    override fun onResponse(res: T) {
        deferred.resolve(res)
    }

    override fun onFailure(e: Throwable) {
        when (e) {
            is Exception -> deferred.reject(e)
            else -> deferred.reject(Exception(e))
        }
    }
}

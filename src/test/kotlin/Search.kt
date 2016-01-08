import nl.komponents.kovenant.*
import nl.komponents.kovenant.functional.withContext
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SearchTest {
    @Before fun setup() {
        Kovenant.context {
            callbackContext.dispatcher = DirectDispatcher.instance
            workerContext.dispatcher = DirectDispatcher.instance
        }
    }
}
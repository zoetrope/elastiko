package elastiko

import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.common.transport.TransportAddress
import java.net.InetAddress

public fun TransportClient.Builder.settings(block: Settings.Builder.() -> Unit) {
    val set = Settings.settingsBuilder()
            .apply { block() }
            .build()
    this.settings(set)
}

public fun address(hostname: String, port: Int): TransportAddress {
    return InetSocketTransportAddress(InetAddress.getByName(hostname), port)
}

public fun transportClient(nodes: List<TransportAddress>, block: TransportClient.Builder.() -> Unit): Client {
    val client = TransportClient.builder()
            .apply { block() }
            .build()
    nodes.forEach {
        client.addTransportAddress(it)
    }
    return client
}

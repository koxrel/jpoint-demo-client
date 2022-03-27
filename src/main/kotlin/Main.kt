import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletionStage
import java.util.concurrent.CountDownLatch

fun main(args: Array<String>) {
    val clients = mutableListOf<WebSocket>()
    for (i in 1..180) {
        for (j in 1..15_000) {
            val ws: WebSocket = HttpClient
                .newHttpClient()
                .newWebSocketBuilder()
                .buildAsync(URI.create("ws://10.129.0.11:8080/ws/failing/calculation"), WebSocketClient())
                .join()
            ws.sendText("Hello!", true)

            clients.add(ws)
        }
        println(i)
        Thread.sleep(1_000)
    }
}

class WebSocketClient() : WebSocket.Listener {
    override fun onOpen(webSocket: WebSocket) {
//        println("onOpen using subprotocol " + webSocket.subprotocol)
        super.onOpen(webSocket)
    }

    override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
//        println("onText received $data")
//        latch.countDown()
//        return super@Listener.onText(webSocket, data, last)
        return super.onText(webSocket, data, last)
    }

    override fun onError(webSocket: WebSocket, error: Throwable) {
//        println("Bad day! $webSocket")
        super.onError(webSocket, error)
    }
}

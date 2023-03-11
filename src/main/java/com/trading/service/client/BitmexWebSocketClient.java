package com.trading.service.client;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONObject;
public class BitmexWebSocketClient extends WebSocketClient {

    public BitmexWebSocketClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to BitMEX WebSocket API");
        JSONObject subscription = new JSONObject();
        subscription.put("op", "subscribe");
        subscription.put("args", List.of("orderBookL2:BMEXUSDT"));
        send(subscription.toString());
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);

        JSONObject jsonObject = new JSONObject(message);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        JSONObject jsonData = jsonArray.getJSONObject(0);
        System.out.println(jsonArray);
        System.out.println(jsonData);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Disconnected from BitMEX WebSocket API");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("Error occurred: " + ex.getMessage());
    }

    public static void main(String[] args) throws URISyntaxException {
        //URI uri = new URI("wss://www.bitmex.com/realtime");
        URI uri = new URI("wss://ws.testnet.bitmex.com/realtime");
        BitmexWebSocketClient client = new BitmexWebSocketClient(uri);
        client.connect();
    }
}

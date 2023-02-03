package com.trading.models.bitmex;

import com.trading.models.order.Order;
import com.trading.util.Expires;
import com.trading.util.Signature;
import com.trading.util.url.URL;
import com.trading.util.url.Verb;
import com.trading.util.url.bitmex.BitmexResourcePath;
import com.trading.util.url.bitmex.BitmexURL;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BitmexHttpClient {
    private final Bitmex bitmex;
    private final HttpClient client;

    public BitmexHttpClient(Bitmex bitmex) {
        this.bitmex = bitmex;
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendOrder(Order order) {
        URL url = createBitmexURL();
        String jsonOrder = new JSONObject(order).toString();
        String expires = Expires.NEW.create();
        String signature = new Signature().createSignature(url, Verb.POST.get(), jsonOrder, expires, bitmex.getApiSecret());

//        while(signature.length() != 64) {
//            expires = Expires.NEW.create();
//            signature = new Signature().createSignature(url, Verb.POST.get(), jsonOrder, expires, bitmex.getApiSecret());
//        }

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonOrder))
                .header("api-signature", signature)
                .header("api-expires", expires)
                .header("api-key", bitmex.getApiKey())
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json")
                .uri(URI.create(url.toString()))
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    private URL createBitmexURL() {
        return URL.builder()
                .protocol(BitmexURL.PROTOCOL.get())
                .net(bitmex.getNet())
                .baseUrl(BitmexURL.BASE_URL.get())
                .apiPath(BitmexURL.API_PATH.get())
                .resourcePath(BitmexResourcePath.ORDER.get())
                .build();
    }
}

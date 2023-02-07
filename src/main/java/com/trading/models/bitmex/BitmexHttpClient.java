package com.trading.models.bitmex;

import com.trading.Main;
import com.trading.models.order.Order;
import com.trading.models.order.Symbol;
import com.trading.util.Expires;
import com.trading.util.Signature;
import com.trading.util.url.URL;
import com.trading.util.url.Verb;
import com.trading.util.url.bitmex.BitmexResourcePath;
import com.trading.util.url.bitmex.BitmexURL;
import org.json.JSONArray;
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

    public HttpResponse<String> getOrderBook() {
        URL url = createBitmexURL(BitmexResourcePath.ORDER_BOOK);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url + "?symbol=" + Symbol.XBTUSD.get() + "&depth=1"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public HttpResponse<String> sendOrder(Order order) {
        URL url = createBitmexURL(BitmexResourcePath.ORDER);
        String data = new JSONObject(order).toString();
        String expires = Expires.NEW.create();
        String signature = new Signature().createSignature(url, Verb.POST.get(), data, expires, bitmex.getApiSecret());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(data))
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

    private URL createBitmexURL(BitmexResourcePath path) {
        return URL.builder()
                .protocol(BitmexURL.PROTOCOL.get())
                .net(bitmex.getNet())
                .baseUrl(BitmexURL.BASE_URL.get())
                .apiPath(BitmexURL.API_PATH.get())
                .resourcePath(path.get())
                .build();
    }
    public double getPrice() {
        JSONArray jsonArray = new JSONArray(getOrderBook().body());
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String price = String.valueOf(jsonObject.get("price"));
        return Double.parseDouble(price);
    }
}

package com.trading.service.client;

import com.trading.model.bitmex.Bitmex;
import com.trading.data.dto.OrderDTO;
import com.trading.model.order.Symbol;
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
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class BitmexClient implements Client {
    private final Bitmex bitmex;
    private final HttpClient client;

    public BitmexClient(Bitmex bitmex) {
        this.bitmex = bitmex;
        this.client = HttpClient.newHttpClient();
    }

    // Получить последнюю цену String
    public String getPrice(Symbol symbol, int depth) {
        JSONArray jsonArray = new JSONArray(getOrderBook(symbol, depth).body());
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String price = jsonObject.get("price") + " " + jsonObject.getString("symbol");
        Instant instant = Instant.parse(String.valueOf(jsonObject.get("timestamp")));
        return "Price: " + price + " \n" + convertTimeStamp(instant);
    }

    // Получить последнюю цену Double
    public double getDoublePrice(Symbol symbol, int depth) {
        return new JSONArray(getOrderBook(symbol, depth).body())
                .getJSONObject(0)
                .getDouble("price");
    }

    // GET запрос к Bitmex на получение ордерной книги
    public HttpResponse<String> getOrderBook(Symbol symbol, int depth) {
        URL url = createBitmexURL(BitmexResourcePath.ORDER_BOOK);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url + "?symbol=" + symbol + "&depth=" + depth))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    // POST запрос на выставление ордера
    public HttpResponse<String> sendOrder(OrderDTO orderDTO) {
        URL url = createBitmexURL(BitmexResourcePath.ORDER);
        String data = new JSONObject(orderDTO).toString();
        String expires = new Expires().toString();
        String signature = new Signature().createSignature(url, Verb.POST.get(), data, expires, bitmex.getApiSecret());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString(data))
                .header("api-signature", signature)
                .header("api-expires", expires)
                .header("api-key", bitmex.getApiKey())
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json")
                .uri(URI.create(url.toString()))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    // Вспомогательные методы

    private URL createBitmexURL(BitmexResourcePath path) {
        return URL.builder()
                .protocol(BitmexURL.PROTOCOL.get())
                .net(bitmex.getNet())
                .baseUrl(BitmexURL.BASE_URL.get())
                .apiPath(BitmexURL.API_PATH.get())
                .resourcePath(path.get())
                .build();
    }

    private String convertTimeStamp(Instant instant) {
        LocalDate date = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        LocalTime time = LocalTime.ofInstant(instant, ZoneId.systemDefault());
        return "Date: " + date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + "\n" +
               "Time: " + time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}

package com.trading;

import com.trading.data.dto.UserDTO;
import com.trading.models.bitmex.Bitmex;
import com.trading.models.bitmex.BitmexClient;
import com.trading.models.order.Order;
import com.trading.models.order.OrderSide;
import com.trading.models.order.OrderType;
import com.trading.models.order.Symbol;
import org.json.JSONArray;

import java.net.http.HttpResponse;

public class Main {
    public static void main(java.lang.String[] args) {

        System.out.println("Welcome to Trading Framework!");
        System.out.println("-".repeat(55));

        /** Начало программы **/

        // 1. Регистрируем пользователя
        UserDTO user = new UserDTO(
                1L,
                "NAME",
                "2C5FhJuJMw6pKqKcGdqIZNsj",
                "Me9Pyl9qHxD8USMvIh4UezJPgbvUTMHT7Wl2VknpLUh632tJ"
        );

        // 2. Создаем платформу
        Bitmex bitmex = Bitmex.builder()
                .isTestnet(true)
                .apiKey(user.getApiKey())
                .apiSecret(user.getApiSecret())
                .build();

        // 3. Подключаемся к платформе
        BitmexClient bhc = new BitmexClient(bitmex);

        // 4. Создаем data request
        Order order = Order.builder()
                .symbol(Symbol.BMEXUSDT)
                .side(OrderSide.BUY.get())
                .orderType(OrderType.LIMIT.get())
                .price(1.0)
                .orderQty(1000.0)
                .build();

        // 5. Посылаем запрос
        String price = bhc.getPrice(Symbol.BMEXUSDT);
        HttpResponse<String> sendOrder = bhc.sendOrder(order);
        HttpResponse<String> orderBook = bhc.getOrderBook(Symbol.BMEXUSDT);

        // 6. Получаем ответ
        System.out.println("-".repeat(55));
        System.out.println(price);
        System.out.println("-".repeat(55));
        System.out.println("Send order response: \n" + sendOrder.body());
        System.out.println("-".repeat(55));
        System.out.println("Order book response: \n" + orderBook.body());
    }
}

package com.trading;

import com.trading.dto.UserDTO;
import com.trading.models.bitmex.Bitmex;
import com.trading.models.bitmex.BitmexHttpClient;
import com.trading.models.order.Order;
import com.trading.models.order.OrderSide;
import com.trading.models.order.OrderType;
import com.trading.models.order.Symbol;

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
                "WQ1aBsyISR2r-4yETA8dFQvS",
                "_t2ZDgBFOw0R3fy5QD5UfRp7UWT_1votUopd59nGgZyW4SRz"
        );

        // 2. Создаем платформу
        Bitmex bitmex = Bitmex.builder()
                .isTestnet(true)
                .apiKey(user.getApiKey())
                .apiSecret(user.getApiSecret())
                .build();

        // 3. Подключаемся к платформе
        BitmexHttpClient bhc = new BitmexHttpClient(bitmex);

        // 4. Создаем data request
        Order order = Order.builder()
                .symbol(Symbol.XBTUSD.get())
                .side(OrderSide.BUY.get())
                .orderType(OrderType.LIMIT.get())
                .price(1.0)
                .orderQty(100.0)
                .build();

        // 5. Посылаем запрос
        String price = bhc.getPrice();
        HttpResponse<String> sendOrder = bhc.sendOrder(order);
        HttpResponse<String> orderBook = bhc.getOrderBook();

        // 6. Получаем ответ
        System.out.println("-".repeat(55));
        System.out.println(price);
        System.out.println("-".repeat(55));
        System.out.println("Send order response: \n" + sendOrder.body());
        System.out.println("-".repeat(55));
        System.out.println("Order book response: \n" + orderBook.body());
    }
}

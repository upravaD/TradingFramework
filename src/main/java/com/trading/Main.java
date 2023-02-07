package com.trading;

import com.trading.models.bitmex.Bitmex;
import com.trading.models.bitmex.BitmexHttpClient;
import com.trading.models.order.Order;
import com.trading.models.order.OrderSide;
import com.trading.models.order.OrderType;
import com.trading.models.order.Symbol;
import com.trading.models.user.User;
import com.trading.util.Expires;
import com.trading.util.Signature;
import com.trading.util.url.URL;
import com.trading.util.url.Verb;
import com.trading.util.url.bitmex.BitmexResourcePath;
import com.trading.util.url.bitmex.BitmexURL;
import org.json.JSONObject;
import org.w3c.dom.ls.LSOutput;

import java.net.http.HttpResponse;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("Welcome to Trading Framework!");

//        TradingService tradingService = new TradingService(PlatformManager.DEMO);
//        tradingService.trade(10, 200, 3, 1, Symbol.XBTUSD);



        /** Начало программы **/
//
        // 1. Регистрируем пользователя
        User user = new User(1L, "NAME");

        // 2. Создаем платформу
        Bitmex bitmex = Bitmex.builder()
                .isTestnet(true)
                .apiKey("WQ1aBsyISR2r-4yETA8dFQvS")
                .apiSecret("_t2ZDgBFOw0R3fy5QD5UfRp7UWT_1votUopd59nGgZyW4SRz")
                .build();

        // 3. Подключаемся к платформе
        BitmexHttpClient bhc = new BitmexHttpClient(bitmex);

        // 4. Создаем data request
        Order order = Order.builder()
                .symbol(Symbol.XBTUSD.get())
                .orderSide(OrderSide.BUY.get())
                .orderType(OrderType.LIMIT.get())
                .price(1.0)
                .orderQty(100.0)
                .build();

        // 5. Посылаем запрос
        HttpResponse<String> result = bhc.sendOrder(order);

        // 6. Получаем ответ
        System.out.println(result.body());
    }
}

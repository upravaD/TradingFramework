package com.trading;

import com.trading.data.dao.UserDAO;
import com.trading.data.dto.UserDTO;
import com.trading.data.entity.User;
import com.trading.model.bitmex.Bitmex;
import com.trading.service.client.BitmexClient;
import com.trading.data.dto.OrderDTO;
import com.trading.model.order.OrderSide;
import com.trading.model.order.OrderType;
import com.trading.model.order.Symbol;

import java.util.List;

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
        OrderDTO orderDTO = OrderDTO.builder()
                .symbol(Symbol.BMEXUSDT)
                .side(OrderSide.BUY.get())
                .orderType(OrderType.LIMIT.get())
                .price(1.0)
                .orderQty(1000.0)
                .build();

        // 5. Посылаем запрос
        UserDAO userDAO = new UserDAO();
        List<User> all = userDAO.getAll();
        System.out.println(all.toString());
        //String price = bhc.getPrice(Symbol.BMEXUSDT, 1);
        //double price = bhc.getDoublePrice(Symbol.BMEXUSDT, 1);
        //HttpResponse<String> sendOrder = bhc.sendOrder(order);
        //HttpResponse<String> orderBook = bhc.getOrderBook(Symbol.BMEXUSDT, 1);

        // 6. Получаем ответ
        System.out.println("-".repeat(55));

        //System.out.println("Price: " + price);
        System.out.println("-".repeat(55));

        //System.out.println("Order response: \n" + sendOrder.body());
        System.out.println("-".repeat(55));

        //System.out.println("OrderBook response: \n" + orderBook.body());
    }
}

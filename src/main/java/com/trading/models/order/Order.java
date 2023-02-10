package com.trading.models.order;

import lombok.*;

/**
 *  Модель выставляемого ордера
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Order {
    private String symbol;
    private String side;
    private Double price;
    private Double orderQty;
    private String orderType;
}

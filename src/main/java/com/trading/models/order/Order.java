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
    private String orderSide;
    private Double orderQty;
    private Double price;
    private String orderType;
}

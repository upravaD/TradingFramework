package com.trading.data.dto;

import com.trading.model.order.Symbol;
import lombok.*;

/**
 *  Модель выставляемого ордера
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDTO {
    private Symbol symbol;
    private String side;
    private Double price;
    private Double orderQty;
    private String orderType;
}

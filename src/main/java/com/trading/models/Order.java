package com.trading.models;

import com.trading.models.enums.OrderSide;
import com.trading.models.enums.Symbol;

/**
 *  Модель выставляемого ордера
 */

public class Order {
    private OrderSide orderSide;
    private Symbol symbol;

    public Order(OrderSide orderSide, Symbol symbol) {
        this.orderSide = orderSide;
        this.symbol = symbol;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderSide=" + orderSide +
                ", symbol=" + symbol +
                '}';
    }
}

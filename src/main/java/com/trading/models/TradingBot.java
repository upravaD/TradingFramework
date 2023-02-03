package com.trading.models;

import com.trading.models.order.Order;
import com.trading.models.order.OrderSide;
import com.trading.models.order.Symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель торгового бота
 */

public class TradingBot {
    private static TradingBot tradingBot;
    private double step;
    private int level;
    private double coef;
    private List<Order> orders;

    public TradingBot() {
    }

    public void botInit(double step, int level, double coef) {
        this.step = step;
        this.level = level;
        this.coef = coef;
        orders = new ArrayList<>();
    }

    public static TradingBot getInstance() {
        if (tradingBot == null) {
            tradingBot = new TradingBot();
        }
        return tradingBot;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(OrderSide orderSide, Symbol symbol) {
        //orders.add(new Order(orderSide, symbol));
    }
}

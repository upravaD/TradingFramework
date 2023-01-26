package com.trading.models;

import com.trading.models.enums.OrderSide;
import com.trading.models.enums.Symbol;

import java.util.ArrayList;
import java.util.List;

/**
 *  Модель торгового бота
 */

public class TradingBot {
    private double step;
    private int level;
    private double coef;
    private final List<Order> orders = new ArrayList<>(level);

    public TradingBot(double step, int level, double coef) {
        this.step = step;
        this.level = level;
        this.coef = coef;
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

    public void setOrders(List<Order> orders, OrderSide orderSide, Symbol symbol) {
        orders.add(new Order(orderSide, symbol));
    }
}

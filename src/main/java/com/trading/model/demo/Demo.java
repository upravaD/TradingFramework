package com.trading.model.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель демонстрационной платформы
 */

@Getter
@Setter
@NoArgsConstructor
public class Demo {
    private static Demo demo;
    private double startPrice;
    private double currentPrice;
    private final List<Double> prises = new ArrayList<>();

    public static Demo getInstance() {
        if (demo == null) {
            demo = new Demo();
        }
        return demo;
    }
}

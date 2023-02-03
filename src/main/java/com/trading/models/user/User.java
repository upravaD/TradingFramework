package com.trading.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  Пользователь
 */

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String name;
}

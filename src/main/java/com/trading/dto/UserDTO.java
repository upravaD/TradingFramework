package com.trading.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  Пользователь
 */

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String apiKey;
    private String apiSecret;
}

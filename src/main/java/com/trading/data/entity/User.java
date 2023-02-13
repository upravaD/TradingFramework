package com.trading.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "bitmex")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "api_key")
    private String apiKey;
    @Column(name = "api_secret")
    private String apiSecret;

}

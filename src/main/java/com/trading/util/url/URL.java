package com.trading.util.url;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class URL {
    private String protocol;
    private String net;
    private String baseUrl;
    private String apiPath;
    private String resourcePath;

    @Override
    public String toString() {
        return protocol + net + baseUrl + apiPath + resourcePath;
    }
}

package com.shelfy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
     날짜 : 2025/01/30
     이름 : 강은경
     내용 : AladinProperties 생성

*/


@Component
@ConfigurationProperties(prefix = "aladin")
public class AladinProperties {
    private String apiKey;    // API 키
    private String baseUrl;   // 기본 URL

    // Getter와 Setter 메서드
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
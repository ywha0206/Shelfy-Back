package com.shelfy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.shelfy.config.AladinProperties;

@Service
public class AladinService {

    @Autowired
    private RestTemplate restTemplate; // RestTemplate 주입

    @Autowired
    private AladinProperties aladinProperties; // AladinProperties 주입

    public String searchBooks(String query) {
        // YML에서 가져온 API 키와 기본 URL을 사용하여 URL 생성
        String url = String.format("%s?TTBKey=%s&Query=%s&QueryType=Title&MaxResults=10&Start=1&SearchTarget=Book&Output=js",
                aladinProperties.getBaseUrl(), aladinProperties.getApiKey(), query);
        return restTemplate.getForObject(url, String.class); // API 호출
    }
}
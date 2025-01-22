package com.shelfy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shelfy.service.AladinService;

@RestController
public class AladinController {

    @Autowired
    private AladinService aladinService;

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query) {
        return aladinService.searchBooks(query);
    }
}
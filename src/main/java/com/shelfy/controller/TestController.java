package com.shelfy.controller;

import com.shelfy.dto.TestDTO;
import com.shelfy.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public List<TestDTO> getTestEntities() {
        return testService.getAll();
    }
}

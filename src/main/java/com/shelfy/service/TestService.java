package com.shelfy.service;

import com.shelfy.dto.TestDTO;
import com.shelfy.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<TestDTO> getAll() {
        return testMapper.selectAll();
    }
}

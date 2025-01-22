package com.shelfy.mapper;

import com.shelfy.dto.TestDTO;
import com.shelfy.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("SELECT id, name, age FROM test_table")
    List<com.shelfy.dto.TestDTO> selectAll();
}

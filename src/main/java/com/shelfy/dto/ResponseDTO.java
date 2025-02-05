package com.shelfy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {


    private boolean success;
    private T response;
    private int status;
    private String errorMessage;


    // 성공 응답을 위한 static 메서드
    public static <T> ResponseDTO<T> success(T response) {
        return new ResponseDTO<>(true, response, 200, null);
    }

    // 실패 응답을 위한 static 메서드
    public static <T> ResponseDTO<T> fail(int status, String errorMessage) {
        return new ResponseDTO<>(false, null, status, errorMessage);
    }




}

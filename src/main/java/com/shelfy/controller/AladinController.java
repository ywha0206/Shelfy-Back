package com.shelfy.controller;

import com.shelfy.dto.BookDTO;
import com.shelfy.service.AladinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
     날짜 : 2025/01/30
     이름 : 강은경
     내용 : AladinController 생성

*/

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Log4j2
public class AladinController {

    private final AladinService aladinService;

    // 📌 1차 검색 (도서 목록 반환 + DB 저장)
    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam String query) {
        return aladinService.searchBooks(query);
    }

    // 📌 2차 검색 (ISBN으로 페이지 수 가져오기) - 책 검색 후 상세페이지
    @GetMapping("/detail")
    public BookDTO getBookDetail(@RequestParam String bookIsbn) {
        log.info(bookIsbn);
        return aladinService.getBookDetail(bookIsbn);
    }
}

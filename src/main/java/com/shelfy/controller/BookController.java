package com.shelfy.controller;

import com.shelfy.document.BookDocument;
import com.shelfy.dto.BookDTO;
import com.shelfy.dto.ResponseDTO;
import com.shelfy.service.AladinService;
import com.shelfy.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
     날짜 : 2025/02/04
     이름 : 강은경
     내용 : BookController 생성

*/

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Log4j2
public class BookController {

    private final BookService bookService;


    /**
     * 도서 검색
     * @param query
     * @return List<BookDTO>
     */
    @GetMapping("/search")
    public ResponseDTO<List<BookDTO>> searchBooks(@RequestParam String query) {
        log.info("책 검색 query : " + query);

        List<BookDTO> bookDTOList = bookService.searchBooks(query);
        log.info("책 검색 반환 bookDTOList : " + bookDTOList);

        // 검색 결과가 없으면 204 No Content 반환
        if (bookDTOList.isEmpty()) {
            return new ResponseDTO<>(true, bookDTOList, HttpStatus.NO_CONTENT.value(), null);
        }

        // 검색 성공 (200 OK)
        return ResponseDTO.success(bookDTOList);
    }

    // 2차 검색 (ISBN으로 페이지 수 가져오기) - 책 검색 후 상세페이지
//    @GetMapping("/detail")
//    public BookDTO getBookDetail(@RequestParam String bookIsbn) {
//        log.info(bookIsbn);
//        return aladinService.getBookDetail(bookIsbn);
//    }






}

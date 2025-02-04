package com.shelfy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;
/*
     날짜 : 2025/01/30
     이름 : 강은경
     내용 : BookDTO 생성
     JsonProperty를 사용하면 기존 필드명 유지하면서 json 속성과 매핑 가능
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // 📌 알 수 없는 JSON 필드를 자동 무시
public class BookDTO {
    private int bookId;  // 책 ID

    @JsonProperty("cover")
    private String bookImage;  // 책 표지 이미지

    @JsonProperty("title")
    private String bookTitle;  // 책 제목

    @JsonProperty("description")
    private String bookDesc;  // 책 설명

    @JsonProperty("author")
    private String bookAuthor;  // 저자

    @JsonProperty("publisher")
    private String bookPublisher;  // 출판사

    @JsonProperty("isbn13")
    private String bookIsbn;  // ISBN

    @JsonProperty("itemPage")
    private int bookPage;  // 페이지 수

    @JsonProperty("pubDate")
    private String bookPublishedAt;  // 출판일 (String 그대로 유지)

    // bookinfo 내부의 itemPage 값을 자동 매핑
    @JsonProperty("bookinfo")
    private void unpackNestedBookInfo(BookInfo bookinfo) {
        if (bookinfo != null) {
            this.bookPage = bookinfo.getItemPage(); // itemPage 값을 bookPage에 저장
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookInfo {
        private int itemPage; // bookinfo 내부의 페이지 수
    }
}
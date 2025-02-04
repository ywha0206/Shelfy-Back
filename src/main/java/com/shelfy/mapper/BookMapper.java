package com.shelfy.mapper;

import com.shelfy.dto.BookDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/*
     날짜 : 2025/01/30
     이름 : 강은경
     내용 : BookMapper 생성

*/
@Mapper
public interface BookMapper {

    // 도서 데이터 저장 (중복 방지)
    @Insert("INSERT INTO tb_book (book_image, book_title, book_desc, book_author, book_publisher, book_isbn, book_page, book_published_at) " +
            "VALUES (#{bookImage}, #{bookTitle}, #{bookDesc}, #{bookAuthor}, #{bookPublisher}, #{bookIsbn}, #{bookPage}, #{bookPublishedAt}) " +
            "ON DUPLICATE KEY UPDATE " +
            "book_page = VALUES(book_page), book_desc = VALUES(book_desc)")
    void insertBook(BookDTO book);

    // ISBN으로 도서 중복 확인
    @Select("SELECT COUNT(*) FROM tb_book WHERE book_isbn = #{bookIsbn}")
    int checkBookExists(String bookIsbn);

    // 저장된 도서 목록 검색
    @Select("SELECT * FROM tb_book WHERE book_title LIKE CONCAT('%', #{query}, '%')")
    List<BookDTO> searchBooks(String query);

    @Update("UPDATE tb_book SET book_page = #{bookPage} WHERE book_isbn = #{bookIsbn}")
    void updateBookPages(BookDTO book);
}

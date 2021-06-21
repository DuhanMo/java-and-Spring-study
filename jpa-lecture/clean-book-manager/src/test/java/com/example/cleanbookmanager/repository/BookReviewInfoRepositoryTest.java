package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.Book;
import com.example.cleanbookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;
    @Test
    void crud() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setId(1L);
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setReviewCount(3);
        bookReviewInfo.setAverageReviewScore(3.3f);


        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>" + bookReviewInfoRepository.findById(1L));

    }
    @Test
    void crud2() {
        givenBookReviewInfo();
        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow().getBook();

        System.out.println(">>>" + result);

        BookReviewInfo bookReviewInfo = bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo();
        System.out.println(">>>" + bookReviewInfo);
    }
    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);
        book.setCategory("장편소설");

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }
}
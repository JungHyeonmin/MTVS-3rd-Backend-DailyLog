package com.ohgiraffers.mapping.section02.embedded;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class EmbeddedTests {

    @Autowired
    private BookRegistService bookRegistService; // 빈이 없어서 빨간줄이 생긴다. (컴파일에러 x)

    private static Stream<Arguments> getBook() {
        return Stream.of(
                Arguments.of(
                        "자바의 정석",
                        "남궁성",
                        "도우출판",
                        LocalDate.now(),
                        30000,
                        0.1
                )
        );
    }

    private static Stream<Arguments> negativePrice() {
        return Stream.of(
                Arguments.of(
                        "자바의 정석",
                        "남궁성",
                        "도우출판",
                        LocalDate.now(),
                        -30000,
                        0.1
                )
        );

    }

    // Stream<Arguments> : JUnit5에서 매개변수를 사용한 테스트를 작성할 때,
    //                     여러개의 인자를 그룹화하여 제공하기 위해 사용되는 데이터 구조
    private static Stream<Arguments> negativeDiscountRate() {
        return Stream.of( // Stream.of를 이용하여 Arguments 객체들을 스트림으로 반환
                          // 각 Arguments 객체는 하나의 테스트 케이스에 필요한 모든 인자를 포함한다.
                Arguments.of( // JUnit5에서 매개변수화된 테스트를 작성할 때,
                              // 각 테스트 케이스에 필요한 인자들을 그룹화하여 전달하는 메서드
                        "자바의 정석",
                        "남궁성",
                        "도우츨판",
                        LocalDate.now(),
                        30000,
                        -0.1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("negativeDiscountRate")
    void testNegativeDiscountRate(String bookTitle, // 매개변수를 받고
                                  String author,
                                  String publisher,
                                  LocalDate publishedDate,
                                  int regularPrice,
                                  double discountRate) {
        
        // 인자를 저장할 DTO 객체를 생성
        BookRegistRequestDTO bookInfo =
                new BookRegistRequestDTO(bookTitle, author, publisher, publishedDate, regularPrice, discountRate);

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bookRegistService.registBook(bookInfo)
        );

        Assertions.assertEquals("할인율은 음수일 수 없습니다.", exception.getMessage());
    }
    
    // 테스트 메서드를 여러 번 실행할 수 있도록 하는 JUnit5 의 어노테이션 - 반복 기준은 서로 다른 매개변수를 기준으로 한다.
    @ParameterizedTest
    // MethodSource() : 매개변수를 제공하는 메서드를 지정
    @MethodSource("negativePrice") 
    void testNegativePrice(String bookTitle,
                           String author,
                           String publisher,
                           LocalDate publishedDate,
                           int regularPrice,
                           double discountRate) {

        BookRegistRequestDTO bookInfo =
                new BookRegistRequestDTO(bookTitle, author, publisher, publishedDate, regularPrice, discountRate);

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bookRegistService.registBook(bookInfo)
        );

        Assertions.assertEquals("가격은 음수일 수 없습니다.", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getBook")
    void testCreateEmbeddedPriceOfBook(String bookTitle,
                                       String author,
                                       String publisher,
                                       LocalDate publishedDate,
                                       int regularPrice,
                                       double discountRate) {

        BookRegistRequestDTO bookInfo =
                new BookRegistRequestDTO(bookTitle, author, publisher, publishedDate, regularPrice, discountRate);

        Assertions.assertDoesNotThrow(
                () -> bookRegistService.registBook(bookInfo)
        );
    }
}

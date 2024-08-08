package com.ohgiraffers.springdatajpa.section03.pagingandsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
public class PagingAndSorTests {

    @Autowired
    private PagingAndSortService pagingAndSortService;

    @DisplayName("페이징하여 메뉴 목록 조회")
    @ParameterizedTest
    @CsvSource({"0,5", "1,5"})
    void testFindAllMenusWithPagingAndPaging(int offset, int limit) {

        Assertions.assertDoesNotThrow(
                () -> {
                    // 항상 DTO 목록을 받아온다고 생각하자!
                    Page<FoundMenuResponseDTO> page = pagingAndSortService.findAllMenusWithPaging(offset, limit);
                    System.out.println("조회한 내용 목록 : " + page.getContent());    // 실제 사용된 데이터
                    System.out.println("총 페이지 수 : " + page.getTotalPages());    // 총 페이지 수
                    System.out.println("총 메뉴 수 : " + page.getTotalElements());  // 전체 보여줘야 하는 목록의 개수
                    System.out.println("첫 페이지 여부 : " + page.isFirst());        // 첫 페이지 여부
                    System.out.println("마지막 페이지 여부 : " + page.isLast());      // 마지막 페이지 여부
                    System.out.println("정렬 방식 : " + page.getSort());            // 정렬
                    page.forEach(System.out::println);
                }
        );
    }

    @DisplayName("정렬하여 메뉴 목록 조회")
    @ParameterizedTest
    @ValueSource(strings = {"menuName", "menuPrice"})
    void testFindAllMenusOrderBy(String columnName) { // 키워드(파라미터)를 기반으로 정렬처리

        Assertions.assertDoesNotThrow(
                () -> {
                    pagingAndSortService.findAllMenusOrderBy(columnName)
                            .forEach(System.out::println);
                }
        );
    }
}

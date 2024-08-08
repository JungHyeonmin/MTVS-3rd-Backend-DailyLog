package com.ohgiraffers.springdatajpa.section02.querymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.QueryMethod;

import java.util.List;

@SpringBootTest
public class QueryMethodTests {

    @Autowired
    private QueryMethodService queryMethodService;

    @DisplayName("원하는 가격 이상의 메뉴 목록 조회")
    @ParameterizedTest
    @ValueSource(ints = {5000, 7000, 9000})
    void testFindByMenuPriceGraterThan(int menuPrice) {

        Assertions.assertDoesNotThrow(
                () -> {
                    List<FoundMenuResponseDTO> foundMenus = queryMethodService.findByMenuPriceGreaterThan(menuPrice);
                    foundMenus.forEach(System.out::println);
                }
        );
    }

    @DisplayName("메뉴 이름으로 메뉴 검색")
    @ParameterizedTest
    @ValueSource(strings = {"한우", "마늘"})
    void testFindByMenuNameContaining(String menuName) {

        Assertions.assertDoesNotThrow(
                () -> {
                    List<FoundMenuResponseDTO> foundMenus = queryMethodService.findByMenuNameContaining(menuName);
                    foundMenus.forEach(System.out::println);
                }
        );
    }
}

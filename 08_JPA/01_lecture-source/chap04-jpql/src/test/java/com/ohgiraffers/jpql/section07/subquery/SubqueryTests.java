package com.ohgiraffers.jpql.section07.subquery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SubqueryTests {

    // JPQL 도 서브쿼리를 지원한다.
    // 하지만 select , from 절에서는 사용할 수 없고, where, having 절에서만 사용이 가능하다.

    @Autowired
    public SubqueryService subqueryService;

    @DisplayName("서브쿼리를 이용한 메뉴 조회 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"한식", "일식", "커피"})
    void tstFindAllMenusByCategoryNameUsingSubquery(String categoryName) {

        Assertions.assertDoesNotThrow(
                () ->{
                    List<Menu> menus = subqueryService.findAllMenusByCategoryNameUsingSubQuery(categoryName);
                    menus.forEach(System.out::println);
                }
        );

    }
}

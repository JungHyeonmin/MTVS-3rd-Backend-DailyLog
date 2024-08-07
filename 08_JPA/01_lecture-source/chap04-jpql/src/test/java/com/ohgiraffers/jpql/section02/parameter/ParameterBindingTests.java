package com.ohgiraffers.jpql.section02.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParameterBindingTests {

    @Autowired
    private ParameterBindingMenuFindService parameterBindingMenuFindService;

    // 파라미터를 바인딩 하는 방법
    // 1. 이름 기준 파라미터 : ':'다음에 이름 기준 파라미터를 지정한다.
    // 2. 위치 기준 파라미터 : '?' 다음에 값을 주고 위치 값은 1부터 시작한다.

    @DisplayName("이름 기준 파라미터 바인딩 메뉴 조회 테스트")
    @ParameterizedTest
    @CsvSource({"1,열무김치라떼", "2,우럭스무디", "3,생갈치쉐이크"})
    void testNameBinding(int menuCode, String expectedMenuName) {

        Menu foundMenu = parameterBindingMenuFindService.bindParameterWithName(menuCode);

        Assertions.assertEquals(expectedMenuName, foundMenu.getMenuName());
    }

    @DisplayName("순번 기준 파라미터 바인딩 메뉴 조회 테스트")
    @ParameterizedTest
    @CsvSource({"1,열무김치라떼", "2,우럭스무디", "3,생갈치쉐이크"})
    void testOrderBinding(int menuCode, String expectedMenuName) {

        Menu foundMenu = parameterBindingMenuFindService.bindingParameterWithOrder(menuCode);

        Assertions.assertEquals(expectedMenuName, foundMenu.getMenuName());
    }
}
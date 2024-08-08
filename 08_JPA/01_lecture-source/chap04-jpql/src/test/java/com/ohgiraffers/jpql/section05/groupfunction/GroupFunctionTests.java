package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GroupFunctionTests {

    /**
     * JPQL 의 그룹함수는 COUNT, MAX, MIN, SUM, AVG 로 SQL 의 그룹함수와 별반 차이가 없다.
     * 단, 몇 가지 주의사항이 있다.
     * 1. 그룹함수의 반환 타입은 결과값이 정수이면 Long, 실수이면 Double 로 반환된다.
     * 2. 값이 없는 상태에서 COUNT 를 제외한 그룹함수는 null 이 되고 count 만 0이 된다.
     * 따라서 반환 값을 담기 위해 선언하는 변수 타입을 기본자료형으로 하게 되면, 조회 결과를 언박싱 할 때 NPE 가 발생한다.
     * 3. 그룹함수의 반환 자료형은 Long or Double 이기 때문에
     * Having 절에서 그룹함수 결과값과 비교하기 위한 파라미터 타입은 Long or Double 로 해야 한다.
     */

    @Autowired
    private GroupFunctionService groupFunctionService;

    @DisplayName("특정 카테고리에 등록된 메뉴 수 조회")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testCountByCategoryCode(int categoryCode) { // count 를 할 때 아무것도 없으면 0이 나와야한다.


        Assertions.assertDoesNotThrow(
                () -> {
                    long countOfMenu = groupFunctionService.countMenuByCategoryCode(categoryCode);
                    System.out.println("countOfMenu = " + countOfMenu);
                }
        );

    }

    @DisplayName("count 를 제외한 다른 그룹 함수의 조회 결과가 없는 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testSumMenuPriceByCategoryCode(int categoryCode) {
        // 빈 값을 더하면 null 이 나온다.

        // NPE 이 발생하는지 확인하는 메서드
        if (categoryCode == 2 || categoryCode == 3) {
            Assertions.assertThrows(
                    NullPointerException.class,
                    () -> {
                        long sumOfPrice = groupFunctionService.sumMenuPriceByCategoryCode(categoryCode);
                    }
            );
        }

        Assertions.assertDoesNotThrow(
                () -> {
                    Long sumOfPrice = groupFunctionService.sumMenuPriceByCategoryCode(categoryCode);
                }
        );
    }

    @DisplayName("GROUP BY 절과 HAVING 절을 사용한 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = {30000, 40000, 50000, 60000})
    void testSumMenuPriceGroupByCategoryCode(long minPrice) {

        Assertions.assertDoesNotThrow(
                () -> {
                    List<Object[]> sumPriceOfCategories = groupFunctionService.sumMenuPriceGroupByCategoryCode(minPrice);
                    sumPriceOfCategories.forEach(
                            row -> Arrays.stream(row).forEach(System.out::println)
                    );
                }
        );
    }
}

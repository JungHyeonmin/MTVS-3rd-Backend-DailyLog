package com.ohgiraffers.jpql.section01.simple;

import com.ohgiraffers.jpql.sectioin01.simple.Menu;
import com.ohgiraffers.jpql.sectioin01.simple.MenuFindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class SimpleJPQLTests {

    /**
     * JPQL (Java Persistence Query Language)
     * JPQL 은 SQL 보다 간결하며 특정 DBMS 에 의존하지 않는다.
     * <p>
     * JPQL 의 기본 문법
     * SELECT, UPDATE, DELETE 등의 키워드 사용은 SQL 과 동일하다. (INSERT -> persist() 사용)
     * 키워드는 대소문자를 구분하지 않지만, 엔티티와 속성은 대소문자를 구분함에 유의한다.
     * 엔티티의 별칭을 필수적으로 사용해야 한다. 별칭 없이 작성하면 에러가 발생한다.
     * <p>
     * JPQL 사용 방법
     * 1. 작성한 JPQL(문자열)을 entityManager.createQuery() 메서드를 통해 쿼리 객체로 만든다.
     * <p>
     * 2. 쿼리 객첸는 TypedQuery, Query 두 가지가 있다.
     * 2-1. TypedQuery : 반환할 타입을 명확하게 지정하는 방식을 때 사용하며 쿼리 객체의 메서드 실행 결과로 지정한 타입이 반환된다.
     * 2-2. Query : 반환할 타입을 명확하게 지정할 수 없을 때 사용하며 쿼리 객체 메서드의 실행 결과로 Object 또는 Object[] 이 반환된다.
     * <p>
     * 3. 쿼리 객체에서 제공하는 메서드 getSingleResult(), getResultList() 를 호출해서 쿼리를 실행하여 데이터베이스를 조회한다.
     * 3-1. getSingleResult() : 결과가 정확히 한 행일 경우 사용하며 없거나 많으면 예외가 발생한다.
     * 3-2. getResultList() : 결과가 2행 이상일 경우 사용하며 컬렉션을 반환한다. 결과가 없으면 빈 컬렉션을 반환한다.
     */

    @Autowired
    private MenuFindService menuFindService;

    @DisplayName("TypedQuery를 이용한 단일 메뉴 조회 테스트")
    @ParameterizedTest
    @CsvSource({"1, 열무김치라떼", "2, 우럭스무디", "3,생갈치쉐이크"})
    void testSingleResultWithTypedQuery(int menuCode, String expectedMenuName) {

        String foundMenuName = menuFindService.findMenuNameByMenuCode(menuCode);

        Assertions.assertEquals(expectedMenuName, foundMenuName);
    }

    @DisplayName("Query 를 이용한 단일 메뉴 조회 테스트")
    @ParameterizedTest
    @CsvSource({"1, 열무김치라떼", "2, 우럭스무디", "3,생갈치쉐이크"})
    void testSingleResultWithQuery(int menuCode, String expectedMenuName) {

        Object foundMenuName = menuFindService.findObjectByMenuCode(menuCode);

        Assertions.assertEquals(expectedMenuName, foundMenuName);
    }

    @DisplayName("TypedQuery 를 이용한 다중행 조회 테스트")
    @Test
    void testMultiRowResultWithTypedQuery() {

        List<Menu> foundMenus = menuFindService.findAllMenusWithTypedQuery();

        Assertions.assertNotNull(foundMenus);
        foundMenus.forEach(System.out::println);
    }

    @DisplayName("Query 를 이용한 다중행 조회 테스트")
    @Test
    void testMultiRowResultWithQuery() {

        List<Menu> foundMenus = menuFindService.findAllMenusWithQuery();

        Assertions.assertNotNull(foundMenus);
        foundMenus.forEach(System.out::println);
    }

    @DisplayName("DISTINCT 를 활용한 중복 제거 여러 행 조회 테스트")
    @Test
    void testDistinctKeyword() {

        List<Integer> categoryCodes = menuFindService.findAllCategoryCodeInMenu();

        Assertions.assertNotNull(categoryCodes);
        categoryCodes.forEach(System.out::println);
    }

    private static Stream<Arguments> menuCodeList() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 6, 7)),
                Arguments.of(List.of(8, 9, 10)),
                Arguments.of(List.of(11, 12))
        );
    }

    @DisplayName("IN 연산자를 활용한 조회 테스트")
    @ParameterizedTest
    @MethodSource("menuCodeList")
    void testInOperator(List<Integer> categoryCodes) {

        List<Menu> foundMenus = menuFindService.findMenusInCategoryCodes(categoryCodes);

        Assertions.assertNotNull(foundMenus);
        foundMenus.forEach(System.out::println);

    }

    @DisplayName("LIKE 연산자를 활용한 조회 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"딸기", "밥", "마늘"})
    void testLikeOperator(String searchValue) {

        List<Menu> foundMenus = menuFindService.searchMenusBySearchValue(searchValue);

        Assertions.assertNotNull(foundMenus);
        foundMenus.forEach(System.out::println);
    }
}

package com.ohgiraffers.springdatajpa.section01.crud;

import jakarta.transaction.Transactional;
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
public class SpringDataJpaCRUDTests {

    @Autowired
    private SpringDataJpaCRUDService crudService;

    @DisplayName("전체 목록 조회 테스트")
    @Test
    void testFindAllMenus() {

        Assertions.assertDoesNotThrow(
                () -> {
                    // dto 를 만들어서 전달한다.
                    List<FoundMenuResponseDTO> menus = crudService.findAllMenus();
                    menus.forEach(System.out::println);
                }
        );
    }

    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testFindMenuCode(int menuCode) {

        Assertions.assertDoesNotThrow(
                () -> {
                    FoundMenuResponseDTO foundMenu = crudService.findMenuByMenuCode(menuCode);
                    System.out.println("foundMenu = " + foundMenu);
                }
        );
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of(
                        new MenuRegistRequestDTO(
                                "새로운 메뉴1",
                                10000,
                                4,
                                "Y"
                        )),
                Arguments.of(
                        new MenuRegistRequestDTO(
                                "새로운 메뉴2",
                                20000,
                                5,
                                "Y"
                        )
                )
        );

    }


    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    @Transactional
    void testRegistNewMenu(MenuRegistRequestDTO newMenu) {

        Assertions.assertDoesNotThrow(
                () -> crudService.registNewMenu(newMenu)
        );

        crudService.findAllMenus().forEach(System.out::println);
    }

    @DisplayName("메뉴 아이디로 메뉴 이름 수정하기 테스트")
    @ParameterizedTest
    @CsvSource({"1, 수정할 메뉴 이름 1", "2, 수정할 메뉴 이름 2"})
    void testModifyMenuName(int menuCode, String menuName) {

        Assertions.assertDoesNotThrow(
                () -> {
                    crudService.modifyMenuName(menuCode, menuName);
                }
        );
        System.out.println(crudService.findMenuByMenuCode(menuCode));
    }

    @DisplayName("메뉴 삭제하기 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7})
    @Transactional
    void testRemoveMenu(int menuCode) {

        Assertions.assertDoesNotThrow(
                () -> {
                    crudService.removeMenu(menuCode);
                }
        );
        crudService.findAllMenus().forEach(System.out::println);
    }
}

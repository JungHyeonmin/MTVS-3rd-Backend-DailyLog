package com.ohgiraffers.midnightpractice.model;

import com.ohgiraffers.midnightpractice.model.dto.itemdto.FoundItemResponseDTO;
import com.ohgiraffers.midnightpractice.model.dto.itemdto.ItemRegistRequestDTO;
import com.ohgiraffers.midnightpractice.model.service.ItemService;
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
public class TestItem {

    @Autowired
    private ItemService itemService;


    private static Stream<Arguments> newItem() {
        return Stream.of(
                Arguments.of(
                        new ItemRegistRequestDTO(
                                "3m 대검",
                                "검",
                                "완전 긴 대검이다.",
                                100000L
                        )
                )
        );
    }


    @DisplayName("아이템 생성")
    @ParameterizedTest
    @MethodSource("newItem")
    @Transactional
    void testRegistNewItem(ItemRegistRequestDTO newItem) {
        Assertions.assertDoesNotThrow(
                () -> itemService.registNewItem(newItem)
        );
    }


    // 플레이어 전체 조회
    @DisplayName("아이템 전체 조회")
    @Test
    void testFindAllItems() {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<FoundItemResponseDTO> items = itemService.findAllItems();
                    items.forEach(System.out::println);
                }
        );
    }


    // 플레이어 정보 수정
    @DisplayName("아이템 이름 수정")
    @ParameterizedTest
    @CsvSource("1, 깅왕짱 무기")
    void testModifyItemName(Long itemNo, String newItemName) {
        Assertions.assertDoesNotThrow(
                () -> {
                    itemService.modifyItemName(itemNo, newItemName);
                }
        );
        System.out.println(itemService.findAllItems());
    }

    @DisplayName("아이템 이름 삭제")
    @ParameterizedTest
    @ValueSource(longs = {1})
    @Transactional
    void testRemoveItemById(Long itemNo) {
        Assertions.assertDoesNotThrow(
                () -> itemService.removeItem(itemNo)
        );
        System.out.println(itemService.findAllItems());
    }
}

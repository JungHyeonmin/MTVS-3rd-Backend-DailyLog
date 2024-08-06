package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class IdClassCompositeKeyTests {

    @Autowired
    private CartRegistService cartRegistService;

    private static Stream<Arguments> getCartInfo() {
        return Stream.of(
                Arguments.of(1, 2, 10),
                Arguments.of(1, 3, 5),
                Arguments.of(2, 1, 1),
                Arguments.of(2, 2, 20)
        );
    }

    @ParameterizedTest(name = "{0}번 회원이 {1}번 책을 카트에 {2}권 담았는지 테스트")
    @MethodSource("getCartInfo")
    void testAddItemToCart(int cartOwnerMemberNo, int addedBookNo, int quantity) {
        
        // DTO 로 묶어서 서비스로 전달
        CartRegistRequestDTO cartInfo = new CartRegistRequestDTO(cartOwnerMemberNo, addedBookNo, quantity);

        Assertions.assertDoesNotThrow(
                () -> cartRegistService.addItemToCart(cartInfo)
        );
    }
}

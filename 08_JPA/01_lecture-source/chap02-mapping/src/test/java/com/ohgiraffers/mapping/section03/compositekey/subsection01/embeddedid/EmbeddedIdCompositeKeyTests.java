package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

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
public class EmbeddedIdCompositeKeyTests {

    @Autowired
    private LikeBookService likeBookService;

    private static Stream<Arguments> getLikeInfos() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 1),
                Arguments.of(2, 2)
        );
    }

    @ParameterizedTest(name = "{0}번 회원이 {1}번 책을 좋아요 등록 테스트")
    @MethodSource("getLikeInfos")
    void testGenerateLike(int likedMemberNo, int likedBookNo) {

        Assertions.assertDoesNotThrow(
                () -> likeBookService.generateLikeBook(new LikeBookRequestDTO(likedMemberNo, likedBookNo))
        );
    }
}

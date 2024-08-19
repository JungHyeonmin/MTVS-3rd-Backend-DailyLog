package com.ohgiraffers.midnightpractice.model;

import com.ohgiraffers.midnightpractice.model.dto.playerdto.FoundPlayerResponseDTO;
import com.ohgiraffers.midnightpractice.model.dto.playerdto.PlayerRegistRequestDTO;
import com.ohgiraffers.midnightpractice.model.service.PlayerService;
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
public class TestPlayer {

    @Autowired
    private PlayerService playerService;


    private static Stream<Arguments> newPlayer() {
        return Stream.of(
                Arguments.of(
                        new PlayerRegistRequestDTO(
                                "user1",
                                1
                        )
                )
        );
    }

    // 플레이어 생성
    @DisplayName("플레이어 생성")
    @ParameterizedTest
    @MethodSource("newPlayer")
    @Transactional
    void testRegistNewPlayer(PlayerRegistRequestDTO newPlayer) {
        Assertions.assertDoesNotThrow(
                () -> playerService.registNewPlayer(newPlayer)
        );
    }


    // 플레이어 전체 조회
    @DisplayName("플레이어 전체 조회")
    @Test
    void testFindAllPlayers() {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<FoundPlayerResponseDTO> players = playerService.findAllPlayers();
                    players.forEach(System.out::println);
                }
        );
    }


    // 플레이어 정보 수정
    @DisplayName("플레이어 이름 수정")
    @ParameterizedTest
    @CsvSource("1, 타락파워전사")
    void testModifyPlayerName(Long playerNo, String newPlayerName) {
        Assertions.assertDoesNotThrow(
                () -> {
                    playerService.modifyPlayerName(playerNo, newPlayerName);
                }
        );
        System.out.println(playerService.findAllPlayers());
    }

    @DisplayName("플레이어 이름 삭제")
    @ParameterizedTest
    @ValueSource(longs = {1})
    @Transactional
    void testRemovePlayerById(Long playerNo) {
        Assertions.assertDoesNotThrow(
                () -> playerService.removePlayer(playerNo)
        );
        System.out.println(playerService.findAllPlayers());
    }
}

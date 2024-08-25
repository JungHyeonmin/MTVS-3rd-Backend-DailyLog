package com.ohgiraffers.midnightpractice.model.dto.playerdto;

import com.ohgiraffers.midnightpractice.model.Player;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoundPlayerResponseDTO {

    private String playerName;
    private Integer playerLevel;

    // db 에서 플레이어 정보 가져오기
    public FoundPlayerResponseDTO(Player player) {
        this(
                player.getPlayerName(),
                player.getPlayerLevel()
        );
    }
}

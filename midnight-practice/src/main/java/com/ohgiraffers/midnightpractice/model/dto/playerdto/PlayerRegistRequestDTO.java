package com.ohgiraffers.midnightpractice.model.dto.playerdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRegistRequestDTO {

    private String playerName;
    private Integer playerLevel;

}

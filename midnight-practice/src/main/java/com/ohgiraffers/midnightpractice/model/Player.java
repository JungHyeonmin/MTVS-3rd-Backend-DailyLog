package com.ohgiraffers.midnightpractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Embeddable
@Table(name = "tbl_player")
public class Player {

    @Id
    @Column(name = "PLAYER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;


    @Column(name = "PLAYER_NAME")
    private String playerName;

    @Column(name = "PLAYER_LEVEL")
    private Integer playerLevel;

    public Player(String playerName, Integer playerLevel) {
        this.playerName = playerName;
        this.playerLevel = playerLevel;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
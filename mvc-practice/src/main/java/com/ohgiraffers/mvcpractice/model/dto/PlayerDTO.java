package com.ohgiraffers.mvcpractice.model.dto;

public class PlayerDTO {
    private int playerNo;
    private String playerName;
    private String playerPassword;

    public PlayerDTO() {}

    public PlayerDTO(int playerNo, String playerName, String playerPassword) {
        this.playerNo = playerNo;
        this.playerName = playerName;
        this.playerPassword = playerPassword;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "playerNumber=" + playerNo +
                ", playerName='" + playerName + '\'' +
                ", playerPassword='" + playerPassword + '\'' +
                '}';
    }
}

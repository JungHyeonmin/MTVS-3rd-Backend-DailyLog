package com.ohgiraffers.common;


public class MemberDTO {
    private Long id;
    private String nickname;

    public MemberDTO(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

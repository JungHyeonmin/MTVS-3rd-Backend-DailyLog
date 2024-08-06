package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

public class LikeBookRequestDTO {

    private int likedMemberNo;
    private int likedBookNo;

    public LikeBookRequestDTO(int likedMemberNo, int likedBookNo) {
        this.likedMemberNo = likedMemberNo;
        this.likedBookNo = likedBookNo;
    }

    public int getLikedMemberNo() {
        return likedMemberNo;
    }

    public int getLikedBookNo() {
        return likedBookNo;
    }

    @Override
    public String toString() {
        return "LikeBookRequestDTO{" +
                "likedMemberNo=" + likedMemberNo +
                ", likedBookNo=" + likedBookNo +
                '}';
    }
}
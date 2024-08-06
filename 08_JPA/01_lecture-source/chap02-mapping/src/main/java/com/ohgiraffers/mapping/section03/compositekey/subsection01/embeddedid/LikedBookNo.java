package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class LikedBookNo {

    @Column(name = "LIKED_BOOK_NO")
    private int likedBookNo;

    protected LikedBookNo() {
    }

    public LikedBookNo(int likedBookNo) {
        this.likedBookNo = likedBookNo;
    }

    public int getLikedBookNo() {
        return likedBookNo;
    }

    public void setLikedBookNo(int likedBookNo) {
        this.likedBookNo = likedBookNo;
    }

    @Override
    public String toString() {
        return "LikedBookNo{" +
                "likedBookNo=" + likedBookNo +
                '}';
    }
}

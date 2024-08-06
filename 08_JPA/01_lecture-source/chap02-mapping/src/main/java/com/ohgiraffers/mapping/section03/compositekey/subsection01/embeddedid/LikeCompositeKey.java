package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class LikeCompositeKey {

    @Embedded
    private LikedMemberNo memberNo;

    @Embedded
    private LikedBookNo bookNo;

    protected LikeCompositeKey() {
    }

    public LikeCompositeKey(LikedMemberNo memberNo, LikedBookNo bookNo) {
        this.memberNo = memberNo;
        this.bookNo = bookNo;
    }

    public LikedMemberNo getMemberNo() {
        return memberNo;
    }

    public LikedBookNo getBookNo() {
        return bookNo;
    }

    @Override
    public String toString() {
        return "LikeCompositeKey{" +
                "memberNo=" + memberNo +
                ", bookNo=" + bookNo +
                '}';
    }
}
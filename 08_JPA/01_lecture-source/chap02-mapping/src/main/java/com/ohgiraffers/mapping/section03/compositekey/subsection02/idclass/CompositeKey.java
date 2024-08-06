package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import java.io.Serializable;

// 왜 인터페이스 구현?
public class CompositeKey implements Serializable {

    private int cartOwner;
    private int addedBook;

    protected CompositeKey() {
    }

    public CompositeKey(int cartOwner, int addedBook) {
        this.cartOwner = cartOwner;
        this.addedBook = addedBook;
    }


}

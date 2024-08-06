package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
@IdClass(CompositeKey.class) // 데이터 베이스 친화적인 방식
public class Cart {

    // 기본키에서 사용 가능한 타입만 사용할 수 있다.
    @Id
    @Column(name = "CART_OWNER")
    private int cartOwner; // 회원 번호

    @Id
    @Column(name = "ADDED_BOOK")
    private int addedBook;

    @Column(name = "quantity")
    private int quantity;

    public Cart() {
    }

    public Cart(int cartOwnerMemberNo, int addedBookNo, int quantity) {
        this.cartOwner = cartOwnerMemberNo;
        this.addedBook = addedBookNo;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartOwner=" + cartOwner +
                ", addedBook=" + addedBook +
                ", quantity=" + quantity +
                '}';
    }
}

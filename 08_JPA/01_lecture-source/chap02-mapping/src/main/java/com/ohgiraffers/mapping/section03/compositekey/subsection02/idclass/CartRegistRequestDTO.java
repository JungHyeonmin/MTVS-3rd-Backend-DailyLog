package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

public class CartRegistRequestDTO {

    private int cartOwnerMemberNo;
    private int addedBookNo;
    private int quantity;

    public CartRegistRequestDTO() {}

    public CartRegistRequestDTO(int cartOwnerMemberNo, int addedBookNo, int quantity) {
        this.cartOwnerMemberNo = cartOwnerMemberNo;
        this.addedBookNo = addedBookNo;
        this.quantity = quantity;
    }

    public int getCartOwnerMemberNo() {
        return cartOwnerMemberNo;
    }

    public void setCartOwnerMemberNo(int cartOwnerMemberNo) {
        this.cartOwnerMemberNo = cartOwnerMemberNo;
    }

    public int getAddedBookNo() {
        return addedBookNo;
    }

    public void setAddedBookNo(int addedBookNo) {
        this.addedBookNo = addedBookNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartRegistRequestDTO{" +
                "cartOwnerMemberNo=" + cartOwnerMemberNo +
                ", addedNookNo='" + addedBookNo + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

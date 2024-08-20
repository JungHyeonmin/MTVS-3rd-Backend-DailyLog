package com.ohgiraffers.midnightpractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_inventory")
public class Inventory {

    @EmbeddedId
    private Long playerNo;

    @EmbeddedId
    @Column(name="ITEM_NO")
    private Long ItemNo;

    @Column(name = "ITEM_QUANTITY")
    private int ItemQuantity;

}

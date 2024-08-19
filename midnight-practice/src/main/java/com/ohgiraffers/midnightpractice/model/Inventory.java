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
public class Inventory {

    @Column
    @Embedded
    private int playerNo;

    @Embedded
    private String ItemName;

}

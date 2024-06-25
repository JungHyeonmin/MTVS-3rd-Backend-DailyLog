package com.ohgiraffers.common;

// 리스코프 치환 원칙 : 계약에 의한 설계를 해야한다.
public interface Account {
    String getBalance();                // 잔액 조회

    String deposit(int money);          // 입금

    String withdraw(int money);         // 출금
}


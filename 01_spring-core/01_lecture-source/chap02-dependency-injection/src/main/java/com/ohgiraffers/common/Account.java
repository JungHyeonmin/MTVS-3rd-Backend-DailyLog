package com.ohgiraffers.common;

// 리스코프 치환 원칙 : 계약에 의한 설계를 해야한다.

// Account(계좌) 인터페이스를 구현한  PersonalAccount(개인 계좌)클래스가 있고
// MemberDTO 는 Account 타입을 필드로 가지고 있다.(MemberDTO 는 Account 타입에 의존한다.)

public interface    Account {
    String getBalance();                // 잔액 조회

    String deposit(int money);          // 입금

    String withdraw(int money);         // 출금
}


package com.ohgiraffers.common;

// 리스코프 치환 원칙 : 계약에 의한 설계를 해야한다.
// 훅 메서드 : 아무것도 작성하지 않은 메서드
public class PersonalAccount implements Account {

    private final int bankCode;
    private final String accNo;
    private int balance; // 정수형 값은 기본값이 0이다.]

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() { // 잔액 조회
        return this.accNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) { // 입금
        String str = "";

        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금 되었습니다";
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }

        return str;
    }

    @Override
    public String withdraw(int money) { // 출금
        String str = "";

        if (money > this.balance) {
            str = "잔액이 부족합니다.";
        } else {
            this.balance -= money;
            str = money + "원이 출금되었습니다. 잔액은 " + this.balance + "원 입니다.";
        }
        return str;

    }
}

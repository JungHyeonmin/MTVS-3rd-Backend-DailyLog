package com.ohgiraffers.section02.reflection;

public class Account {

    private String bankXCode;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String bankXCode, String accNo, String accPwd) {
        this.bankXCode = bankXCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankXCode, String accNo, String accPwd, int balance) {
        this.bankXCode = bankXCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은" + this.balance + "원 입니다.";
    }

    public String deposit(int money) {
        String str = "";

        if (money > 0) {
            this.balance += money;
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }
        return str;
    }

    public String withdraw(int money) {
        String str = "";

        if (money > 0) {
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요.";
        }
        return str;
    }

    public String getBankXCode() {
        return bankXCode;
    }

    public void setBankXCode(String bankXCode) {
        this.bankXCode = bankXCode;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccPwd() {
        return accPwd;
    }

    public void setAccPwd(String accPwd) {
        this.accPwd = accPwd;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankXCode='" + bankXCode + '\'' +
                ", accNo='" + accNo + '\'' +
                ", accPwd='" + accPwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}

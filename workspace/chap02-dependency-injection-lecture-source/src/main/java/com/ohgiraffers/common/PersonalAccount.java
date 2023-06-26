package com.ohgiraffers.common;

public class PersonalAccount implements Account {


    private String accNo;
    private int balance;

    public PersonalAccount(){}

    public PersonalAccount(String accNo, int balance) {
        this.balance = balance;

    }

    @Override
    public String getBalance() {


        /* 인트형의 자료를 String으로 변환해야함. 어떻게?
         * 숫자 -> 문자열로 : 3가지
         * 1. Integer.valueOf
         * 2. String.valueOf
         * 3. + "";
         * */

//        return Integer.valueOf(this.balance).toString();

//        return String.valueOf(this.balance);

//        return this.balance + "";

        return this.balance + "";


    }

    @Override
    public boolean deposit(int money) {

        if (money <= 0) {
            throw new IllegalArgumentException("입금할 금액이 잘못되었습니다.");
        }

        this.balance += money;

        return true;
    }

    @Override
    public boolean withdraw(int money) {

        if (money > this.balance) {
            throw new IllegalArgumentException("잔액보다 큰 금액을 출금할 수 없습니다.");
        }

        this.balance -= money;

        return true;
    }
}

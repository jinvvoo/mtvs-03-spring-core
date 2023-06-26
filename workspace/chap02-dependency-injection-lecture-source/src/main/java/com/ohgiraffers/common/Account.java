package com.ohgiraffers.common;

public interface Account {

    /* 잔액조회 */
    String getBalance(); //잔금

    /* 입금 */
    boolean deposit(int money); //입금

    /* 출금 */
    boolean withdraw(int money); //출금
}

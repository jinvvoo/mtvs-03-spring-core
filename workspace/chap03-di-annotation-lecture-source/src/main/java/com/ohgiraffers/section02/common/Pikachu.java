package com.ohgiraffers.section02.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //우선권 부여
public class Pikachu implements Pokemon {

    @Override
    public void attack() {

        System.out.println("피카츄 백만볼트!!");
    }
}

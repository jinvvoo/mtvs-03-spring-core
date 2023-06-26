package com.ohgiraffers.section03.proxy.common;

public interface Student {

    public abstract void study(int hour);


    // 바디없이 ;로 끝난거 : 추상메소드,
    // { } 바디
    // study(int hour); 시그니쳐
    // public 접근제한자

    // 동일클래스에 여러개 메소드 작성 가능
    // 메소드 이름 변경도 가능, 매개변수도 약간 변경가능
    // 메소드와 시그니처 차이 : 오버로딩

    // 1.8부터 default 메소트 // inferface는 바디에 메소드가능 but default 붙여



}

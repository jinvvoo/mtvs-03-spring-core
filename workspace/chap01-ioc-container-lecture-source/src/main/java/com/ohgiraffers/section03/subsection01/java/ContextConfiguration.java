package com.ohgiraffers.section03.subsection01.java;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ohgiraffers"})      // 컴퍼넌트 스캔기능 활성화
// 설정파일에 @componentScan을 달아줌
// 이 클래스가 속해있는 모든 패키지를 스캔함
// 이때 @component이 달려있는 클래스를 자기가 알아서 객체로 만들어서 가지고 있음
//
public class ContextConfiguration {

}

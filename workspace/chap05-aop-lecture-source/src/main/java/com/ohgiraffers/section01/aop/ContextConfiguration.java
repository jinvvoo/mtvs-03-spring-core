package com.ohgiraffers.section01.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)    //cglib를 사용하겠다 라는 뜻.

public class ContextConfiguration {



}

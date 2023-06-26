package com.ohgiraffers.section02.javaconfig;


import com.ohgiraffers.common.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Member getMember() {

        return new Member(1, "user01", "pass01", "홍길동");
    }
}

package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
                // 자바 ApplicationContext구현체
                                                      // contextConfiguration.class에 대한 모든 사용권한 위임.

        Member member = context.getBean("getMember", Member.class);
        // common의 Member라는 타입의 빈 꺼내옴

        System.out.println("member =" + member);

    }
}

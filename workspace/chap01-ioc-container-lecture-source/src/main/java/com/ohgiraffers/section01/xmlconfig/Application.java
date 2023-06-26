package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {


        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");


//        Member member = (Member) context.getBean("member");       1번째방식

//        Member member = context.getBean(Member.class);            2번째 방식

        Member member = context.getBean("member", Member.class);    //3번째 방식

        System.out.println("member = " + member);

    }
}

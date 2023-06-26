package com.ohgiraffers.section03.subsection01.java;

import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);

        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);

        System.out.println("memberDAO = " + memberDAO.findMemberBySequence(1));
        System.out.println(memberDAO.save(new Member(3, "user03", "pass03", "신사임당")));
        System.out.println("memberDAO = " + memberDAO.findMemberBySequence(3));

    }

    // member 금액 아이템
    // 금액이 얼마 있는지 먼저 디폴트
    // 입력된 금액이랑 존재하는 아이템의 금액과 비교
    // 적으면 x 같거나 많으면 O

}

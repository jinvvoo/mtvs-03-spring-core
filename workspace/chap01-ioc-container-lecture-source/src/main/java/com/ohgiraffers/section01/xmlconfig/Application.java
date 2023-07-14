package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

//        BeanFactory 대신 ApplicationContext 이용


        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
            //          xml설정을 읽어들이는 구현체 GenericXmlApplicationContext
            //          내가 읽어들이려는 xml파일의 경로 추가
            //          아까 만든 xml파일을 읽어서 얘가 spirng container를 동작시켜주는 구현체

            //          컨테이너가 처음 동작하면 박스(컨테이너)생성됨.
            //          설정 내용을 만들었기에, 우리가 만든 xml안에 member class를 갖고 객체 생성.
            //          우리는 이 객체를 필요한 위치에서 꺼내쓸 때 "너 Bean 가지고 와" 명령을 이용해서 가져옴
            //          그건 바로 getBean 메소드를 이용함.
            // context에서 getBean 메소드를 이용 -> member라는 이름의 bean 가져와 (아래코드)
            // 나중엔 getBean 사용하지않음. 지금은 ioc container 이해하기 위해 사용


        // Member member = context.getBean("member");
        //                (Member)로 다운캐스팅

//        Member member = (Member) context.getBean("member");       1번째방식 (빈의 ID로 가져오는 방법)

//        Member member = context.getBean(Member.class);            2번째 방식 (빈의 타입으로 가져오는 방법)

        Member member = context.getBean("member", Member.class);    //3번째 방식 (1 2번 조합)

        System.out.println("member = " + member);

    }
}

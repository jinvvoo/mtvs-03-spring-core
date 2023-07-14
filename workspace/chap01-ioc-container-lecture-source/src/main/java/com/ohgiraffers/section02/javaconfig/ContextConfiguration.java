package com.ohgiraffers.section02.javaconfig;


import com.ohgiraffers.common.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //일반 자바파일이 아닌 설정파일
public class ContextConfiguration {

    @Bean //빈이라는 어노테이션 이용 (xml에선 태그로 이용했다), 어노테이션은 메소드 레벨에서 작성
            //이때 메소드는 내가 만들려는 빈의 클래스를 리턴타입으로 잡아준다
    public Member getMember() {

        return new Member(1, "user01", "pass01", "홍길동");
        //객체를 만드는 것 같지만, 객체를 생성하는 방법을 알려줌. 이렇게 만들어와라
    }
}


// 처음 컨테이너 만들면 @Configuration이 달린 클래스를 가지고 객체를 만듬
// 컨테이너가 configuration이라는 클래스 또한 빈으로 가지고 있는 상태
// 빈 어노테이션이 달린 모든 메소드를 일괄적으로 호출
// 그때 리턴받은 객체를 컨테이너가 가지고 있게 됨

// 그럼 컨테이너는 맴버라는 이름의 빈을 가지고 있게 됨
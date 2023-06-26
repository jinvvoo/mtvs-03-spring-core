package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args) {

        Student student = new OhgiraffersStudent();
        student.study(10);
        // 일반 메소드 호출

        //스튜던트대신할프록시생성

        Student proxy =
                (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {Student.class}, new Handler(student));

        proxy.study(16);

    }
}

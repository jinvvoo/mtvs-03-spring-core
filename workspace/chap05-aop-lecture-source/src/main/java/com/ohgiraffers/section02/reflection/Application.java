package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) {

        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

//        Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
        // 시작당시가아닌, 코드만나는 런타임 시점에 코드를 로드하는 동적로딩 지원
        // 최초실행에는 실행속도가 느릴 수 있음.

        Class class3 = null;
        try {
            class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;"); //스트링 계열 만드는 클래스 로드
            System.out.println("class6 = " + class6);

            Class class7 = String[].class;
            System.out.println("class7 = " + class7);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Class class8 = Double.TYPE;
        //대문자더블 래퍼크래스. (wrap)
        //타입속성 가지고있음.
        System.out.println("class8 = " + class8);

        Class class9 = Void.TYPE;
        System.out.println("class9 = " + class9);


        //클래스 자료형 객체를 만들 수 있다는걸 보여주는 것

        //클래스 객체를 만들어서 뭘 할수 있냐?


        Class superClass = class1.getSuperclass();
        // 1에 해당하는 어카운트 슈퍼클래스 부모클래스를 클래스 자료형으로 반환
        System.out.println("superClass = " + superClass);

        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
//            System.out.println("modifired" + field.getModifiers()  // modifired는 접근제한자 의미 // 그필드 접근제한자 정보 반환
            System.out.println("modifired" + Modifier.toString(field.getModifiers())  // 문자열형태로 출력

                    + ", type : " + field.getType()

                    + ", name : " + field.getName());
        }

        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor con : constructors) {
            System.out.println("name : " + con.getName());

            Class[] params = con.getParameterTypes();
            for (Class param : params) {
                System.out.println("param = " + param);
            }
        }

//        Account acc = constructors[0].newInstance("20", "110-223-123456", "1234", 10000);

        try {
            Account acc = (Account) constructors[0].newInstance("20", "110-223-123456", "1234", 10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        // 자기가 Account를 알고서 이런정도 할 수 있다 정도만 알아두기


        /* 하단부터 오류 */
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getSimpleName() + " " +
                    method.getName());

            if ("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {
            System.out.println(getBalanceMethod.invoke(constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public void method(Class class1) {}


    //IoC 컨테이너 만드는 기본 원리.
    // 성능 오버헤드 발생가능성 높음
    // 성능 높은 앱에선 사용안하는게 좋음
    // 스프링 프레임워크 이용하면 품질보장 -> 성능 좋아짐 ?  (X)
    // 이 경우만 봐도 아님.

    // 프록시도 : 이런게 있구나, 어렴풋이 알아야 함.

}

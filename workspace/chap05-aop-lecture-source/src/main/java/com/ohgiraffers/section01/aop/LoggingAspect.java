package com.ohgiraffers.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    //별 - 끝나는 모든 파일들 // 매개변수 선언부에 ..은 몇개든 상관없이

    public void logPointCut() {
    }

    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before joinpoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinpoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) { //0보다 크면 매개변수 있는거/ 아니면 없는거
            for (Object param : joinPoint.getArgs()) {
                System.out.println(param);
            }
        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After jointpoint.getSignature() : " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("after returning result : " + result);
    }

    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("exception message : " + exception.getMessage());
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 사전에 동작할 내용
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();


        // 사후에 동작할 내용
        stopWatch.stop();

        System.out.println("메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis());

        return result;
    }
}

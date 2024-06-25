package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

import static javax.swing.UIManager.put;

// @Aspect는 기본적으로 제공하지 않는다. -> mavenRepository에서 라이브러리 추가(Weaver, Runtime)
@Aspect // pointcut, advice를 Aspect에 추가하고
@Component // 빈으로 사용하기 위해서 Component를 사용한다.
public class LoggingAspect {

    // @Pointcut : 여러 joinPoint 를 매치하기 위해 지정한 표현식
    // execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    // 수식어 생략 가능(public, private, protected, default)
    // *Service.*(..) : 마지막에 Service로 끝나는 모든 클래스의 (..)-> 모든 메서드를 의마한다.

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))") // Pointcut 표현식
    public void logPointcut() { // @Pointcut 은 메서드 위에만 사용 가능하다.
        // findAllMembers() 와 findMemberById() 를 joinPoint 를 할 것이다.
    }

    // Advice 정의
    @Before("logPointcut()") // 메서드를 적으면 해당 메서드의 위치에서 작동한다.
    public void logBefore(JoinPoint joinPoint) { // JoinPoint 로 매개변수를 받아야한다.

        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) { // joinPoint 에 Args 인자가 있다면 0번째 인자를 출력
            System.out.println("Before joinPoint.getArgs()[0] = " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // 코멘팅이나 값을 변경해야 할 때 사용한다. // 리턴값을 조작하는 용도
    @AfterReturning(pointcut = "logPointcut()", returning = "result") // 정상적인 동작에서 사용 // 속성을 여러개 쓸 수 있기때문에 속성을 적었다.
    public void logAfterReturning(JoinPoint joinPoint, Object result) { // 리턴해주는 값이 어떤 것인지 모르기 때문에 Object 타입으로 받는다. 이름도 같아야한다.
        System.out.println("\nAfterReturning result : " + result); //

        if (result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }


    // 비정상 종료
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterTrhowing(JoinPoint joinPoint, Exception exception) { // 예외 객체
        System.out.println("AfterThrowing exception : " + exception);

    }

    // ProceedingJoinPoint : JoinPoint의 확장 버전
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 실행한다. */
        Object result = joinPoint.proceed();
        System.out.println("Around After " + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
        return result;
    }
}


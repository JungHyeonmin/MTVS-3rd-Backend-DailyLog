package com.ohgiraffers.section03.proxy.subsection01.dynamic;
// reflect를 이용한 InvocationHandler

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final Student student;

    public Handler(Student student) {
        this.student = student;
    }

    // 앞으로 구현할 proxy 의 설정 파일
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("====== 공부가 너무 하고 싶습니다. ======");
        System.out.println("호출 대상 메서드 : " + method.getName());

        for (Object arg : args) {
            System.out.println("전달된 인자 : " + arg);
        }

        method.invoke(student, args);

        System.out.println("====== 공부를 마치고 수면 학습을 시작합니다. ======");


        return proxy;
    }
}

package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;
import org.springframework.cglib.proxy.InvocationHandler;


import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final OhgiraffersStudent student;

    public Handler(OhgiraffersStudent student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("공부가 너무 하고싶어요");

        method.invoke(student, args);

        System.out.println("왜 벌써 자려구요? 니렙에 잠이 오니.");

        return proxy;
    }
}

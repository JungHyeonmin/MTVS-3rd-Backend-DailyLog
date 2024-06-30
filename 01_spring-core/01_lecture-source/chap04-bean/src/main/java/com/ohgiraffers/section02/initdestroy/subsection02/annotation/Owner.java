package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Owner {
    /* init-method와 같은 설정 어노테이션이다. */
    @PostConstruct // 생성 이전에 실행
    public void openShop() {
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 시작할 수 있습니다.");
    }
    
    /* destroy-method와 같은 설정 어노테이션이다. */
    @PreDestroy // Destroy 이후에 실행
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫았습니다. 이제 집에 가세요.");
    }

}

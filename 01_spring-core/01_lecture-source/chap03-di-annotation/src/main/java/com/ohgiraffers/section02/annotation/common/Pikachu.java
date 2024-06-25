package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 특별한 계층이 없는 클래스는 @Component를 이용해서 빈을 생성해주면 된다.
@Primary
public class Pikachu implements Pokemon {

    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!! ⚡⚡");
    }
}

package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {

        return new PersonalAccount(03, "123456-45-789012");
    }

    @Bean
    public Member memberGenerator() {

        // 1. 생성자 주입
//        return new Member(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());

        // 2. setter 주입
        Member member = new Member();
        member.setSequence(1);
        member.setName("이순신");
        member.setPhone("010-1234-5455");
        member.setEmail("lee123@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}

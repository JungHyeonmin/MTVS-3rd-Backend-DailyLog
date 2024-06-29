package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    /**
     * // Account 객체 생성
     * Account account = new PersonalAccount(20, "110-234-567890");
     * <p>
     * // MemberDTO 객체 생성
     * MemberDTO member = new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", account);
     * <p>
     * 의존성 주입이 없다면 사람이 직접 만들고 넣어주는 작업을 해야한다.
     */

    // Member 객체에 추가 할 PersonalAccount
    @Bean
    public Account accountGenerator() {

        return new PersonalAccount(03, "123456-45-789012");
    }

    @Bean
    public Member memberGenerator() {

        // 1. 생성자를 통해 의존성 객체를 전달하여 의존성을 주입하고 있으므로 이를 생성자 주입 이라 한다.
        // return new Member(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());

        // 2.  setter 를 통해 의존성 객체를 전달하여 의존성을 주입하고 있으므로 이를 세터 주입 이라 한다.
        Member member = new Member();
        member.setSequence(1);
        member.setName("이순신");
        member.setPhone("010-1234-5455");
        member.setEmail("lee123@gmail.com");
        // PersonalAccount 참조
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
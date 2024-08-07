package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest // 기본적인 스프링 부트 테스트 어노테이션
// @Transactional // 선언적 데이터베이스 트랜잭션 관리 방법 제공 클래스와 메서드에 사용 가능, commit, rollback
public class EntityMappingTests {

    /**
     * 엔티티와 테이블을 정확하게 매핑하는 것이 JPA 의 핵심이다.
     * 이를 위해 다양한 매핑 어노테이션(mapping annotation)이 지원되는데 크게 4가지로 분류할 수 있다.
     * 객체와 테이블 : @Entity, @Table
     * 기본키 매핑 : @Id
     * 필드와 컬럼 매핑 : @Column
     * 연관관계 매핑 : @ManyToOne, @OneToMany, @JoinColumn
     */
    @Autowired
    private MemberRegistService memberRegistService;

    private static Stream<Arguments> createMember() {
        return Stream.of(
                Arguments.of(
                        1,
                        "user01",
                        "pass01",
                        "홍길동",
                        "010-1234-5678",
                        "서울시 서초구",
                        LocalDateTime.now(),
                        "ROLE_MEMBER",
                        "Y"
                ),
                Arguments.of(
                        2,
                        "user02",
                        "pass02",
                        "유관순",
                        "010-1234-3131",
                        "서울시 서초구",
                        LocalDateTime.now(),
                        "ROLE_ADMIN",
                        "Y"
                )
        );
    }

    @DisplayName("테이블 만들기 테스트")
    @ParameterizedTest
    @MethodSource("createMember")
    void testCreateTable(int memberNo, String memberId, String memberPwd, String memberName,
                         String phone, String address, LocalDateTime enrollDate, MemberRole memberRole, String status) {
        // 회원 정보 객체 생성 - db에 저장할 정보를 DTO 에 저장해서 전달
        MemberRegistRequestDTO memberInfo = new MemberRegistRequestDTO(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        Assertions.assertDoesNotThrow(
                () -> memberRegistService.registMember(memberInfo)
        );
    }
}
package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// 엔티티 어노테이션 : 해당 클래스를 엔티티로 설정하기 위한 어노테이션
// 프로젝트 내 다른 패키지에도 동일한 엔티티가 존재하는 경우 엔티티를 식별하기 위한
// 중복되지 않는 name 을 지정해 주어야 한다.

// 주의 사항
// 1. 기본생성자는 필수로 작성해야 한다.
// 2. final 클래스, enum, interface, inner class 에서는 사용할 수 없다.
// 3. 기본키가 한 개는 반드시 존재해야 한다.
// 4. 저장할 필드에 final 을 사용하면 안된다.
@Entity(name = "member")
@Table // 매핑될 테이블의 이름을 작성한다. 생략하면 자동으로 클래스의 이름을 테이블 이름으로 사용한다.
public class Member {

    @Id
    // @Id 적용이 가능한 자바 타입
    // 자바 기본형, Wrapper, String, java.util.Date, java.sql.Date, java.math.BigDecimal, java.math.BigInteger
    @Column(name = "MEMBER_NO") // 데이터베이스 테이블의 컬럼명
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 세가지 형태로 사용 가능
    // 1. IDENTITY : 기본 키 생성을 데이터베이스에 위임한다. - mysql
    // 2. SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당한다.
    // 3. TABLE : 키 생성 테이블을 사용한다.
    private int memberNo;

    // name : 매핑할 데이터베이스 컬럼의 이름을 지정
    // unique : 이 컬럼의 값은 테이블 내에서 중복가능 여부
    // nullable : null 값 허용 여부
    // columnDefinition : 데이터베이스에서 사용할 컬럼의 SQL 정의를 직접 정의한다.
    //                  -> 컬럼을 varchar(10)타입으로 지정(최대 10자의 문자열을 저장할 수 있다.)
    //                  -> default 'Y' : 컬럼에 값이 명시되지 않으면 기본값으로 'Y'를 가진다.
    // length : 문자열 컬럼의 최대 길이를 설정 -> (500자)

    @Column(name = "MEMBER_ID", unique = true, nullable = false, columnDefinition = "varchar(10)")
    private String memberId;

    @Column(name = "Member_PWD", nullable = false)
    private String memberPwd;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "ENROLL_DATE")
    private LocalDateTime enrollDate;

    @Column(name = "MEMBER_ROLE")
    // @Enumerated(EnumType.ORDINAL) // 0, 1로 매핑
    @Enumerated(EnumType.STRING) // 문자열로 매핑
    private MemberRole memberRole;

    @Column(name = "STATUS", columnDefinition = "char(1) default 'Y'")
    private String status;

    public Member() {
    }

    public Member(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, MemberRole memberRole, String status) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole=" + memberRole +
                ", status='" + status + '\'' +
                '}';
    }
}

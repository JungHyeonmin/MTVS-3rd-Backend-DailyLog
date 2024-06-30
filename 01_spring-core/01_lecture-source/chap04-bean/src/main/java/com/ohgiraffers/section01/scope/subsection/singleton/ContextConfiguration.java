package com.ohgiraffers.section01.scope.subsection.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 스프링 컨테이너에서 @Configuration 이 붙어있는 클래스를 자동으로 빈으로 등록(관리를 가능하게)해준다.
// 단순히 bean 을 등록(관리)하기 위한 어노테이션이 아니라
// bean 을 등록할 때 싱글톤(singleton)이 되도록 보장해준다.
@Configuration
public class ContextConfiguration {

    // @Bean : 메서드 레벨에서 반환값으로 객체를 스프링 컨테이너에 저장함
    @Bean
    public Product carpBread() {

        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {

        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {

        return new Beverage("지리산암반수", 3000, 500);
    }

    // @singleton : singleton 은 애플리케이션 내에서 하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다. 이를 통해 메모리 사용량을 줄일 수 있으며, 성능 향상을 기대할 수 있다.
    // @Prototype : 스코프를 갖는 Bean 은 매번 새로운 인스턴스를 생성한다. 이를 통해 의존성 주입 등의 작업에서 객체 생성에 대한 부담을 줄일 수 있다.

    @Bean
    // @Scope("singleton")        // @Scope() : 스프링에서 빈의 범위를 지정하는 어노테이션
    @Scope("prototype") //
    public ShoppingCart cart() {
        // shoppingCart() 객체 : 상품을 담는 리스트
        return new ShoppingCart();
    }
    /**
     * Singleton : 기본값, 어플리케이션 내에서 단 하나의 인스턴스만 생성된다.
     * Prototype : 요청할 때마다 새로운 인스턴스가 생성된다.
     * - 웹에서만 사용가능한 범위
     * Request : 각 HTTP 요청마다 하나의 인스턴스가 생성되며, 웹 어플리케이션에서만 유효하다.
     * Session : 각 세션마다 하나의 인스턴스가 생성되며, 웹 어플리케이션에서 세션 범위로 유효하다.
     */
}
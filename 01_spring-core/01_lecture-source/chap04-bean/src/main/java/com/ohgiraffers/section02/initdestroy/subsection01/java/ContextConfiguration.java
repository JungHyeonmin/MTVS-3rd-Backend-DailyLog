package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

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
        return new Beverage("지리산 암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype") // 인스턴스를 생성해서 인스턴스를 싱글톤으로 관리한다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    // init, destroy method : 
    // 스프링 빈은 초기화(init)와 소멸화(destroy)의 라이프 사이클을 가지고 있다.
    // 이 라이프 사이클을 이해하면 빈 객체가 생성되고 소멸될 때 추가적인 작업을 수행할 수 있다.

    /**
     * `init-method` 속성을 사용하면 스프링이 빈 객체를 생성한 다음 초기화 작업을 수행할 메소드를 지정할 수 있다.
     * 이 메소드는 빈 객체 생성자가 완료된 이후에 호출된다.
     * `init-method` 속성으로 지정된 메소드는 일반적으로 빈의 초기화를 위해 사용된다.
     *
     * `destroy-method` 속성을 사용하면 빈 객체가 소멸될 때 호출할 메소드를 지정할 수 있다.
     * 이 메소드는 `ApplicationContext`의 `close()` 메소드가 호출되기 전에 빈 객체가 소멸될 때 호출된다.
     * `destroy-method` 속성으로 지정 된 메소드는 일반적으로 사용하던 리소스를 반환하기 위해 사용된다.
     */

    @Bean(initMethod = "openShop", destroyMethod = "closeShop") // bean 의 초기화와 소멸화를 지정함
    public Owner owner() {
        /* init-method 로 openShop 메소드를 설정하고 destroy-method 로 closeShop 메소드를 설정한다. */
        return new Owner();
    }

    /*
     * XML 설정
     * <bean id="owner" class="com.ohgiraffers.common.Owner" init-method="openShop" destroy-method="closeShop"/>
     */
}

package com.ohgiraffers.section01.scope.subsection.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // 클래스를 빈으로 컨테이너에 저장
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
    @Scope("singleton") // 인스턴스를 생성해서 인스턴스를 싱글톤으로 관리한다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
    /*
    * XML 파일에서 <bean> 태그를 이용할 경우
    * <bean id="cart" class="com.ohgiraffers.common.ShoppingCart" scope="singleton"/>
    * 
    * */
}

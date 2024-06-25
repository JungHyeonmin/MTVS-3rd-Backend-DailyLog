package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 값을 하드코딩하지 않고 properties로 변경, 재사용

@Configuration
@PropertySource("section03/properties/subsection01/properties/product-info.properties") // 어떤 Properties 파일을 읽을건지 경로를 작성
public class ContextConfiguration {

    // 치환자(placeHolder) 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
    // 없는 값을 경로로 지정하면 키값 그대로 추력한다. -> 해결방법 1. 키값 제대로 쓰기 2. 키값 대신 출력할 값을 작성
    // 에러 방지를 위해서 대체 값을 적고 확인하는 것이 좋다.
    @Value("${bread.carpbread.name2:슈크림붕어빵}") // 공백이 있으면 공백을 포함해서 경로를 찾기 때문에 공백이 있으면 안된다.
    private String carpBreadName;


    @Value("${bread.carpbread.price2:0}")// 해당위치의 properties파일에서 값을 가져온다.
    private int carpBreadPrice;


    @Value("${beverage.milk.name:상한우유}") // 우유 이름
    private String milkName;

    @Value("${beverage.milk.price:10000000}") // 우유 가격
    private int milkPrice;

    @Value("${beverage.milk.capacity:0}") // 용량
    private int capacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, capacity);
    }

    // 한번에 넣어서 사용하는 것도 가능하다. 방식은 매개변수에 값을 넣어서 바로 반환
    @Bean
    public Product water(@Value("${beverage.water.name:방사능물}") String waterName,
                         @Value("${beverage.water.price:10000}") int waterPrice,
                         @Value("${beverage.water.capacity:0}") int waterCapacity) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }
}

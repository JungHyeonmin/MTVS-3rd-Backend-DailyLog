package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 상품들을 빈으로 등록할 설정 파일을 작성한다. 이 때 product-info.properties 파일에 기재한 값으로 상품들의 값을 초기화 하려고 한다.
// properties 파일을 읽어올 때 @PropertySource 어노테이션에 경로를 기재하여 읽어올 수 있으므로 읽어올 properties 파일의 경로를 작성한다.

// Properties 는 키/값 쌍으로 이루어진 간단한 파일이다. 보통 소프트웨어 설정 정보를 저장할 때 사용된다.
// 스프링에서는 Properties 를 이용하여 빈의 속성 값을 저장하고 읽어올 수 있다.
@Configuration
@PropertySource("section03/properties/subsection01/properties/product-info.properties") // 어떤 Properties 파일을 읽을건지 파일(경로)를 작성
public class ContextConfiguration {

    /* 치환자(placeholder) 문법을 이용하여 properties 에 저장된 key 를 입력하면 value 에 해당하는 값을 꺼내온다.
     * 공백을 사용하면 값을 읽어오지 못하니 주의한다.
     * : 을 사용하면 값을 읽어오지 못하는 경우 사용할 대체 값을 작성할 수 있다. - 대체값을 작성하는 것을 권장한다.
     **/

    /*
    필드 또는 파라미터에 @Value 어노테이션을 사용할 수 있으며
    해당 어노테이션에 ${key} 와 같이 치환자(placeholder) 문법을 이용하여 properties 에 저장된 key 를 입력하면
    value 에 해당하는 값을 꺼내와 필드 또는 파라미터에 주입한다.
    key 뒤에 : 을 이용하여 해당 key 값이 없을 경우에는 주입할 기본 값을 입력할 수 있다.
     */
    // @Value("${키값:대체값}")
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

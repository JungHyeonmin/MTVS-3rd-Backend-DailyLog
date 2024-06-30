package com.ohgiraffers.section01.scope.subsection.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /**
         * Bean의 Scope
         * singletion : 하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴를 공유하여 사용한다.
         * prototype : 매번 새로운 인스턴스를 생성한다.
         * request : HTTP 요청을 처리할 때 마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다.(웹 애플리케이션 컨텍스트만 식당)
         * session : HTTP 세션당 하나의 인스턴스를 샌성하고, 세션이
         * globalsession : 전역 세션당 하나의 인스턴스를 생성하고, 전역세션이 종료되면 인스턴스를 폐기하낟. (포털 애플리케이션 컨텍스트만 해당)
         * **/


        /* 빈 설정 파일을 기반으로 IoC 컨테이너 생성 */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 각 상품타입에 스프링 컨테이너에 저장 붕어빵, 딸기우유, 지리산 암반수 등의 빈 객체를 반환 받는다. */
        // bean id 를 안적어서 각 메서드명으로 호출한다.
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 첫 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        // 쇼핑카트 리스트에 carpBread, milk 추가
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        /* 붕어빵과 딸기우유가 담겨있다. */
        System.out.println("cart1에 담긴 내용 : " + cart1.getItem());

        /* 두 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        // 쇼핑카트 리스트에 water 추가
        cart2.addItem(water);

        /* 붕어빵과 딸기우유와 지리산암반수가 담겨있다. */
        System.out.println("cart2에 담긴 내용 : " + cart2.getItem());

        /* 두 카드의 hashcode 를 출력해보면 동일한 것을 볼 수 있다. */
        System.out.println("cart1의 hashcode : " + cart1.hashCode());
        System.out.println("cart2의 hashcode : " + cart2.hashCode());

        // 같은 인스턴스를 사용하기 때문에 cart1과 cart2가 공유되어서 모든 상품이 하나의 리스트에 담겨졌다.
        System.out.println("cart1에 담긴 내용" + cart1.getItem());
    }
}

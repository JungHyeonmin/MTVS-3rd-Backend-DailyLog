package com.ohgiraffers.section01.scope.subsection.singleton;

import com.ohgiraffers.common.Beverage;
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


        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // getBean : 빈 인스턴스 조회
        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean(("cart"), ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 = " + cart1.getItems());

        ShoppingCart cart2 = context.getBean(("cart"), ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 = " + cart2.getItems());

        System.out.println("cart1의 hashCode : " + cart1.hashCode()) ;
        System.out.println("cart2의 hashCode : " + cart2.hashCode()) ;
    }
}

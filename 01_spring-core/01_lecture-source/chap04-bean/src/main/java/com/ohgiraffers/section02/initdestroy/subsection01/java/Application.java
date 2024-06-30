package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean(("cart"), ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 = " + cart1.getItem());

        ShoppingCart cart2 = context.getBean(("cart"), ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 = " + cart2.getItem());

        // 컨테이너 종료시킬 수 있는 기능 - AnnotationConfigApplicationContext 애서 제공
        // 자원을 사용하면 close()를 사용해야 한다.
        ((AnnotationConfigApplicationContext) context).close(); // 컨테이너가 종료되면 빈도 사라진다.
    }

}

package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

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

        /* init 메소드는 빈 객체 생성 시점에 동작하므로 바로 확인할 수 있지만
         * destroy 메소드는 빈 객체 소멸 시점에 동작하므로 컨테이너가 종료 되지 않을 경우 확인할 수 없다.
         *
         * 가비지 컬렉터가 해당 빈을 메모리에서 지울 때 destroy 메소드가 동작하게 되는데
         * 메모리에서 지우기 전에 프로세스는 종료되기 때문이다.
         * 따라서 아래와 같이 강제로 컨테이너를 종료시키면 destroy 메소드가 동작할 것이다.
         * */

        // 컨테이너 종료시킬 수 있는 기능 - AnnotationConfigApplicationContext 애서 제공
        // 자원을 사용하면 close()를 사용해야 한다.
        ((AnnotationConfigApplicationContext) context).close(); // 컨테이너가 종료되면 빈도 사라진다.
    }

}

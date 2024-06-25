package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        /**
         * I18N (Internationalization) - 소프트웨어의 국제화 (국제화 말고 현지화 개념도 있음(다양한 것을 통일화한다. - Localization)
         */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 404
        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        //String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA); // 읽어올 메세지의 키값을 입력
        System.out.println("error404MessageKR = " + error404MessageKR);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US); // Local : 다양한 지역의 로케일 값을 찾을 수 있다.
        System.out.println("error404MessageUS = " + error404MessageUS);

        // 505
        String error500MessageKR = context.getMessage("error.500", new Object[]{"정현민", new Date()}, Locale.KOREA);
        System.out.println("error500MessageKR = " + error500MessageKR);

        String error500MessageUS = context.getMessage("error.500", new Object[]{"JungHyeonmin", new Date()}, Locale.US);
        System.out.println("error500MessageUS = " + error500MessageUS);
    }
}

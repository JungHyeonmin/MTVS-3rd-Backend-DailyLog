package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


// 다국어 메세지 처리, 스프링이 이런것도 지원을 하는구나~ 정도로 이해
@Configuration
public class ContextConfiguration {

    // 반드시 Bean으로 설정해야 해야 하는 메서드
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() { // 메세지를 다시 받을 수 있는 저장소

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("section03/properties/subsection02/i18n/message"); // 메세지 이름을 해당 경로로 베이스 네임을 한다.
        messageSource.setCacheSeconds(10); // 10초동안 캐싱한다.
        messageSource.setDefaultEncoding("UTF-8"); // 메세지를 UTF-8로 읽는다.

        return messageSource;
    }
    // Reloadable : 사용자의 로케일 환경에 따라서 메세지를 다시 받을 수 있는 환경
    // Bundle : 저장소
    // MessageSource : 메세지
}

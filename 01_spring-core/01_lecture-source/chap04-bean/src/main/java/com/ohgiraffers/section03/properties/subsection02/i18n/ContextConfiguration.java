package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 국제화(Internationalization 또는 i18n)란, 소프트웨어를 다양한 언어와 문화권에 맞게 번역할 수 있도록 디자인하는 과정이다.
 *
 * Spring Framework 에서 i18n은 MessageSource 인터페이스와 property 파일을 이용하여 구현된다. 각 언어별로 property 파일을 정의하면,
 * Spring 은 사용자의 로케일에 맞게 적절한 파일을 선택하여 애플리케이션 텍스트를 올바르게 번역할 수 있다.
 */

// 다국어 메세지 처리, 스프링이 이런것도 지원을 하는구나~ 정도로 이해
@Configuration
public class ContextConfiguration {

    // 반드시 Bean 으로 설정해야 해야 하는 메서드
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

package com.ohgiraffers.chap08crudpractice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

// @Configuration : 빈 수동 설정
@Configuration
public class BeanConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        // ReloadableResourceBundleMessageSource : Spring 프레임워크에서 국제화(i18n) 메시지를 처리하는데에 사용한다.
        // ReloadableResourceBundleMessageSource 객체 생성
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        // setBasename() : messages 디렉토리 안의 message 파일을 찾는다.
        source.setBasename("classpath:/messages/message");
        // setDefaultEncoding() : 기본 인코딩을 UTF-8로 설정한다.
        source.setDefaultEncoding("UTF-8");
        // setCacheSeconds() : 메시지 파일의 캐시 지속 시간을 설정
        source.setCacheSeconds(30);

        /* 제공하지 않는 언어로 요청 시 messageSource 에서 사용할 default 언어를 한국어로 설정*/
        // Locale : 특정한 지리적, 정치적, 문화적 지역을 나타내는 객체
        Locale.setDefault(Locale.KOREA);

        // 설정이 완료된 ReloadableResourceBundleMessageSource 객체를 반환한다. 이 객체는 이후 애플리케이션에서 메시지 소스로 사용된다.
        return source;
    }
}

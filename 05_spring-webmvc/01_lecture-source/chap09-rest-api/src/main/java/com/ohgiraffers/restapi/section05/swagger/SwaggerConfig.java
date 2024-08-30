package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration // 스프링 설정을 담고 있는 빈임을 알려주는 어노테이션
@EnableWebMvc // Spring web Mvc 설정 파일
public class SwaggerConfig {

    // OpenAPI 객체를 생성하고, 이를 통해 API 의 구성 정보를 설정한다. Info 객체를 포함시켜 기본 정보를 제공하고,
    //                                                           Components 객체를 통해 추가적인 설정을 할 수 있다.
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI() // OpenAPI(): OpenAPI 명세의 루트 객체. 이 객체를 통해 API 의 전반적인 정보와 구성을 정의한다.
                .components(new Components()) // Components(): 재사용 가능한 객체들을 정의하는 컨테이너
                .info(apiInfo()); // Info(): API에 대한 기본 정보를 설정하는 부분(API의 제목, 설명, 버전 등..)
    }

    // API 에 대한 기본 정보를 설정하는 'Info' 객체를 반환하는 메서드. Swagger UI 에서 사용자에게 보여진다.
    private Info apiInfo() {

        return new Info() // 명세서 정보 // http://localhost:8080/swagger-ui/index.html
                .title("SpringBoot REST API Spec") // 제목
                .description("Specification") // 설명
                .version("1.0"); // 버전
    }
}

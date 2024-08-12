package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // Spring web Mvc 설정 파일
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {

        return new Info() // 명세서 정보 // http://localhost:8080/swagger-ui/index.html
                .title("SpringBoot REST API Spec") // 제목
                .description("Specification") // 설명
                .version("1.0"); // 버전
    }
}

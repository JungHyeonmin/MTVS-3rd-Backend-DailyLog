package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        // 에러 : 1개의 포켓몬만 사용하려고 했지만 3개를 저장해 놓은 상태라서 프로그램이 선택을 못한다.(모호성)
        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);
        pokemonService.pokemonAttakck();
    }
}

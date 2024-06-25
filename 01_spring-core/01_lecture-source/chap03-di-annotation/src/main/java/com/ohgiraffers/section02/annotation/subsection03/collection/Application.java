package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 이거는 뭐징
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        
        // PokemonService 클래스
        PokemonService pokemonService = context.getBean("pokemonServiceCollection", PokemonService.class);
        pokemonService.pokemonAttack();
    }
}

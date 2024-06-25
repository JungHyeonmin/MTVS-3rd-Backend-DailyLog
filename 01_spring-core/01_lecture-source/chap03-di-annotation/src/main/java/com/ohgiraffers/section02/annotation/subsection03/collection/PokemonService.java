package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    // 1. List 타입으로 주입
    private List<Pokemon> pokemons;

    /*
    // 같은 타입으로 있는 Bean을 전부 넣는데 리스트에 들어오는 순서는 사전 순으로 들어온다.
    @Autowired
    public PokemonService(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void pokemonAttack() {
        pokemons.forEach(Pokemon::attack); // Pokemon클래스의 attack메서드를 forEach로 반복해라~라는 뜻
    }
    */

    // 2. Map 타입으로 주입
    private final Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> { // (k, v) : 키와 값을 매개변수로 받는다. // 중괄호부터 메서드 정의
            System.out.println("key : " + k);
            System.out.print("공격 : ");
            v.attack();
        });

        System.out.println("===========================");
        // 위의 람다와 같은 내용
        for (Pokemon pokemon : pokemonMap.values()) {
            pokemon.attack();
        }
    }

}

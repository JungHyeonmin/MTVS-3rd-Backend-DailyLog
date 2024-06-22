package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    // 1. List 타입으로 주입
//    private final List<Pokemon> pokemons;
//
//    @Autowired
//    public PokemonService(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
//
//    public void pokemonAttack() {
//        pokemons.forEach(Pokemon::attack);
//    }

    // 2. Map 타입으로 주입
    private final Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key : " + k);
            System.out.println("공격 : ");
            v.attack();
        });

//        for(Pokemon pokemon : pokemonMap.values()) {
//            pokemon.attack();
//        }
    }
}

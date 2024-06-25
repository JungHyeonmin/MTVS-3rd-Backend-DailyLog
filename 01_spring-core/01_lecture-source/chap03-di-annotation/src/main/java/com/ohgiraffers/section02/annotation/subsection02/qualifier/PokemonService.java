package com.ohgiraffers.section02.annotation.subsection02.qualifier;


import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    //    @Autowired // 필드 주입은 final을 사용할 수 없다.
//    @Qualifier("pikachu")
    private Pokemon pokemon;

    @Autowired
    // @Qualifier("pikachu") : @Qualifier은 생성자에서 사용 불가능하다. // 필드, 메서드, 매개변수는 가능하다.
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) { // 매개변수에 사용 가능
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}

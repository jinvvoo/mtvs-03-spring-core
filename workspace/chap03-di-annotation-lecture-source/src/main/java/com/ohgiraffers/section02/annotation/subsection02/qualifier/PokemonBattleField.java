package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fieldQualifier")
public class PokemonBattleField {

//    @Autowired
//    @Qualifier("squirtle")
//    private Pokemon pokemon;

    private Pokemon pokemon;

    public PokemonBattleField(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void fight() {
        pokemon.attack();
    }

}

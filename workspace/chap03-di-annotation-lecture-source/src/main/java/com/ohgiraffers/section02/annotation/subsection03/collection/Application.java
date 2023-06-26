package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        PokemonBattleField pokemonBattleField = context.getBean("fieldCollection", PokemonBattleField.class);

        pokemonBattleField.fight();
    }
}

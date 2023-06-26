package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.sectino02");
        PokemonBattleField pokemonBattleField = context.getBean("fieldQualifier", PokemonBattleField.class);

        pokemonBattleField.fight();

    }
}

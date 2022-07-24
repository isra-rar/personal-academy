package com.fitness.myself.domain.util;

import net.datafaker.Faker;

import java.util.Locale;

public final class FakerSingleton {

    private static Faker instace;

    public static Faker getInstace() {
        if (instace == null) {
            instace = new Faker(new Locale(" pt-BR"));
        }
        return instace;
    }
}

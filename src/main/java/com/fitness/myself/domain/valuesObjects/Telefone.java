package com.fitness.myself.domain.valuesObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import static com.fitness.myself.domain.utils.RegexUtil.REGEX_TELEFONE;

@NoArgsConstructor
@Getter
@Embeddable
public class Telefone {

    private String numeroTelefone;

    public Telefone(String numeroTelefone) {
        if (numeroTelefone == null || !numeroTelefone.matches(REGEX_TELEFONE)) {
            throw new IllegalArgumentException("Telefone invalido");
        }
        this.numeroTelefone = numeroTelefone;
    }

}

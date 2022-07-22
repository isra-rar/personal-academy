package com.fitness.myself.domain.valuesObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import static com.fitness.myself.domain.utils.RegexUtil.REGEX_EMAIL;

@NoArgsConstructor
@Getter
@Embeddable
public class Email {

    private String enderecoEmail;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Email invalido");
        }
        this.enderecoEmail = endereco;
    }

}

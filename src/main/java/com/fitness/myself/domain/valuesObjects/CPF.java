package com.fitness.myself.domain.valuesObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import static com.fitness.myself.domain.utils.RegexUtil.REGEX_CPF;

@NoArgsConstructor
@Getter
public class CPF {

    private String cpf;

    public CPF(String numeroCpf) {
        if (numeroCpf == null || !numeroCpf.matches(REGEX_CPF)) {
            throw new IllegalArgumentException("CPF Invalido");
        }
        this.cpf = numeroCpf;
    }

}

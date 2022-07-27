package com.fitness.myself.domain.valuesObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CPF {

    @org.hibernate.validator.constraints.br.CPF
    private String cpf;

    public CPF(String numeroCpf) {
        this.cpf = numeroCpf;
    }

}

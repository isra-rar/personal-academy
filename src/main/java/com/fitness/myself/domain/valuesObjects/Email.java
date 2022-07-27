package com.fitness.myself.domain.valuesObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Email {

    @javax.validation.constraints.Email
    private String enderecoEmail;

    public Email(String endereco) {
        this.enderecoEmail = endereco;
    }

}

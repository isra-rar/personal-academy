package com.fitness.myself.domain.baseAbstract;

import com.fitness.myself.domain.valuesObjects.CPF;
import com.fitness.myself.domain.valuesObjects.Email;
import com.fitness.myself.domain.valuesObjects.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
public abstract class Usuario extends BaseEntity {

    private String nome;
    @Embedded
    private CPF cpf;
    @Embedded
    private Email email;
    @Embedded
    private Telefone telefone;
    private String password;

}

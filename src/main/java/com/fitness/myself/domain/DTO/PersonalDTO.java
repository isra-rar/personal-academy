package com.fitness.myself.domain.DTO;

import com.fitness.myself.domain.personal.CREF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private CREFDTO cref;

}

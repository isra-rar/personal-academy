package com.fitness.myself.domain.DTO.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

}

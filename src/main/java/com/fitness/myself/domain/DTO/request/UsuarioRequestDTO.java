package com.fitness.myself.domain.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String password;

}

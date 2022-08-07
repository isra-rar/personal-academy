package com.fitness.myself.domain.DTO.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoResponseDTO {

    private Long id;
    private UsuarioDTO usuario;
    private String nomeAcademia;
    private String tipoPlano;

    private FichaPessoalDTO fichaPessoal;

    private Long personalId;
    private String nomePersonal;
}

package com.fitness.myself.domain.DTO.request;

import com.fitness.myself.domain.DTO.response.FichaPessoalDTO;
import com.fitness.myself.domain.DTO.response.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlunoRequestDTO {


    private String nomeAcademia;
    private String tipoPlano;
    private FichaPessoalDTO fichaPessoal;
    private Long personalId;
    private Long usuarioId;

}

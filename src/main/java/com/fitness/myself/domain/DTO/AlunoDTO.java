package com.fitness.myself.domain.DTO;

import com.fitness.myself.domain.enums.TipoPlano;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String nomeAcademia;
    private String tipoPlano;

    private FichaPessoalDTO fichaPessoal;

    private Long personalId;
    private String nomePersonal;
}

package com.fitness.myself.domain.DTO.response;

import com.fitness.myself.domain.enums.GrupoMuscular;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExercicioDTO {

    private Long id;
    private String descricao;
    private int series;
    private int repeticoes;
    private String  grupoMuscular;
}

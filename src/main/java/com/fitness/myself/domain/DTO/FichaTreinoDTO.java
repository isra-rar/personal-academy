package com.fitness.myself.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FichaTreinoDTO {

    private Long id;

    private Long alunoId;
    private String nomeAluno;

    private Long personalId;
    private String nomePersonal;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String tipoFicha;

    private List<ExercicioDTO> exercicios;


}

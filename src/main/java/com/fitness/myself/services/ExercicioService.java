package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.response.ExercicioDTO;
import com.fitness.myself.domain.treino.Exercicio;

import java.util.List;

public interface ExercicioService extends GenericService<Exercicio>{

    Exercicio insert(Exercicio exercicio);
    ExercicioDTO toExercicioDTO(Exercicio exercicio);
    Exercicio toExercicio(ExercicioDTO alunoDTO);

    List<ExercicioDTO> findlAllExercicios();

}

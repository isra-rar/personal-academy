package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.DTO.ExercicioDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.treino.Exercicio;

import java.util.List;

public interface ExercicioService extends GenericService<Exercicio>{

    ExercicioDTO toExercicioDTO(Exercicio exercicio);
    Exercicio toExercicio(ExercicioDTO alunoDTO);

    List<ExercicioDTO> findlAllExercicios();

}
